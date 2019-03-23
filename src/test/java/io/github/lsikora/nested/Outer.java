package io.github.lsikora.nested;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("This test is divided into:  ")
class Outer {
    @DisplayName("Success case")
    @Nested
    class Inner1 {
        @Test
        @DisplayName("I pass")
        void $() {
        }
    }

    @DisplayName("Fail case")
    @Nested
    class Inner {
        @Test
        @DisplayName("I fail")
        void $() {
            fail();
        }
    }
}
