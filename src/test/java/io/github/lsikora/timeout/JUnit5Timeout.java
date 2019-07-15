package io.github.lsikora.timeout;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static java.time.temporal.ChronoUnit.MILLIS;
import static org.junit.jupiter.api.Assertions.assertTimeout;

//todo explain new annotation that works on classes and methods
@Timeout(4)
class JUnit5Timeout {
    @Test
    void willTimeoutWithAssertion() {
        assertTimeout(
                Duration.of(100, MILLIS),
                ()-> sleep(200));
    }

    //todo make slide with pun on how JUnit 5 uses seconds where most API's
    // use miliseconds

    //todo will not timeout because timeout is in seconds by default. Which
    // sucks because unit tests should be fast and not unit test should last
    // a second it should be max few miliseconds long

    //todo does test will not timeout due to no override for default time unit
    // those tests are expected to fail. But they do not.
    @Test
    @Timeout(2)
    void willTimeoutWithMethodTimeout() throws InterruptedException {
        sleep(3);
    }

    @Test
    void willTimeoutWithGlobalTimeoutOnClassLevel() throws InterruptedException {
        sleep(5);
    }
}
