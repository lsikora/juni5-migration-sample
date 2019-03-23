package io.github.lsikora.extensions.naiveGlobalTimeout;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newSingleThreadExecutor;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.fail;

public class GlobalTimeoutExtension implements BeforeTestExecutionCallback {
    private final long timeout;
    private TimeUnit timeUnit;
    private ExecutorService executorService;

    public GlobalTimeoutExtension() {
        timeout = 1L;
        timeUnit = MILLISECONDS;
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception{
        executorService = newSingleThreadExecutor();

        Future<?> submit = executorService.submit(() -> {
                    Method method = context.getRequiredTestMethod();
                    method.setAccessible(true);
                    try {
                        method.invoke(context.getRequiredTestInstance());
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        fail("Test failed due to: " + e);
                    } finally {
                        executorService.shutdownNow();
                    }
        });
        submit.get(timeout, timeUnit);
    }
}
