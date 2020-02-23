package io.github.lsikora.extensions.naiveGlobalTimeout;

import io.github.lsikora.extensions.naiveGlobalTimeout.GlobalTimeoutExtension.GlobalTimeout;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;


@DisplayName("This test shows that simple global timeout will be applied to " +
        "all tests in class")
@GlobalTimeout
class JUnit5WithGlobalTimeout {

    @Test
    void willTimeout() throws InterruptedException {
        sleep(15);
    }

    @Test
    void willTimeout2() throws InterruptedException {
        sleep(11);
    }
}
