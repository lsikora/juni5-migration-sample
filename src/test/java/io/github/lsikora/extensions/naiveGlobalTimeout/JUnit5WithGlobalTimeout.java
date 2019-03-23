package io.github.lsikora.extensions.naiveGlobalTimeout;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static java.lang.Thread.sleep;

@ExtendWith(GlobalTimeoutExtension.class)
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
