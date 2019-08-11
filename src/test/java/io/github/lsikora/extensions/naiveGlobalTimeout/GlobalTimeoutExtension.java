package io.github.lsikora.extensions.naiveGlobalTimeout;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newSingleThreadExecutor;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.fail;

public class GlobalTimeoutExtension implements InvocationInterceptor {
    private final long timeout;
    private TimeUnit timeUnit;
    private ExecutorService executorService;

    public GlobalTimeoutExtension() {
        timeout = 1L;
        timeUnit = MILLISECONDS;
    }

    @Override
    public void interceptTestMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> invocationContext,
                                    ExtensionContext extensionContext) throws InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        executorService = newSingleThreadExecutor();

        Future<?> submit = executorService.submit(() -> {
                    try {
                        invocation.proceed();
                    } catch (Throwable e) {
                        fail("Test failed due to: " + e);
                    } finally {
                        executorService.shutdownNow();
                    }
        });
        submit.get(timeout, timeUnit);
    }
}
