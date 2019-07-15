package io.github.lsikora.timeout;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

//todo explain new annotation that works on classes and methods
//  add note that this timeout is better than havin rule to enforce global
//  timeout in JUnit 4.  Make pun that this annotation declaration is to long
//  since it requires explicit miliseconds specification and JUnit 5 uses
//  seconds by default. Why so large timeouts? Why TimeUnit.MILISECONDS
//  instead of TimeUnit.MILIS which is more coherent with Java APIs
@Timeout(value = 4, unit = MILLISECONDS)
class JUnit5TimeoutWithTimeUnit {
    //todo make slide with pun on how JUnit 5 uses seconds where most API's
    // use miliseconds

    //todo will not timeout because timeout is in seconds by default. Which
    // sucks because unit tests should be fast and not unit test should last
    // a second it should be max few miliseconds long

    //todo does test will not timeout due to no override for default time unit
    @Test
    @Timeout(value = 2, unit = MILLISECONDS)
    void willTimeoutWithMethodTimeout() throws InterruptedException {
        sleep(3);
    }

    @Test
    void willTimeoutWithGlobalTimeoutOnClassLevel() throws InterruptedException {
        sleep(5);
    }
}
