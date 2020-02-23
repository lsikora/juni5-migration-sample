package io.github.lsikora.extensions.naiveGlobalTimeout;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.util.concurrent.Executors.newSingleThreadExecutor;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.fail;

/*This extension has been created before JUnit 5 gained global timeout
capability. It is left in code base to show that implementing extension that
is impacting all tests is simple in JUnit 5*/
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

    @Target({TYPE, METHOD})
    @Retention(RUNTIME)
    @ExtendWith(GlobalTimeoutExtension.class)
    public @interface GlobalTimeout{

    }
}
