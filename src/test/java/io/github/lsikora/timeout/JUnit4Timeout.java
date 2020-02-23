package io.github.lsikora.timeout;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static java.lang.Thread.sleep;

/*This test shows different approaches to make test time out in JUnit 4*/
public class JUnit4Timeout {
    @Rule
    public Timeout timeout = Timeout.millis(100);

    @Test
    public void willTimeoutDueToTimeoutRule() throws InterruptedException {
        sleep(200);
    }

    /*Timeout parameter in test is in miliseconds, which works nicely with
    Thread API*/
    @Test(timeout = 50)
    public void willTimeoutDueToTestAnnotationParam() throws InterruptedException {
        sleep(200);
    }

    @Test
    public void willNotTimeOut() throws InterruptedException {
        sleep(50);
    }
}
