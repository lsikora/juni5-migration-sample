package io.github.lsikora.timeout;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static java.time.temporal.ChronoUnit.MILLIS;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class JUnit5Timeout {
    @Test
    void willTimeout() {
        assertTimeout(
                Duration.of(100, MILLIS),
                ()-> sleep(200));
    }
}
