package io.github.lsikora.imports;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("This test will be executed if JUnit 5 is properly configured")
class JUnit5Simple {

    @Test
    public void testJUnit5IsWorking() {
        assertTrue(true);
    }
}