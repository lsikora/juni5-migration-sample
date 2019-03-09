package io.github.lsikora.timeout;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static java.lang.Thread.sleep;

public class JUnit4Timeout {
    @Rule
    public Timeout timeout = Timeout.millis(100);

    @Test(timeout = 50)
    public void willTimeout() throws InterruptedException{
        sleep(200);
    }
}
