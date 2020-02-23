package io.github.lsikora.timeout;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.lang.Thread.sleep;
import static java.time.Duration.of;
import static java.time.temporal.ChronoUnit.MILLIS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@Timeout(4)
@DisplayName("This test shows different approaches to make test time out in " +
        "JUnit 5:")
class JUnit5Timeout {
    @Test
    @DisplayName("Using assertion without interrupting execution")
    void assertionTimeout() {
        assertTimeout(
                of(100, MILLIS),
                () -> sleep(200)
        );
    }

    @Test
    @DisplayName("Using assertion with interrupting execution")
    void assertionTimeoutPreemptively() {
        assertTimeoutPreemptively(
                of(100, MILLIS),
                () -> sleep(200)
        );
    }

    /*This method is classic example of RTFM. Default unit for timeout is
    seconds. Thread sleeps for milliseconds so test will not timeout*/
    @Test
    @DisplayName("Using @Timeout on class")
    void globalTimeout() throws InterruptedException {
        sleep(5);
    }

    @Test
    @Timeout(value = 2, unit = MILLISECONDS)
    @DisplayName("Using @Timeout on method")
    void annotatedTimeout() throws InterruptedException {
        sleep(3);
    }
}
