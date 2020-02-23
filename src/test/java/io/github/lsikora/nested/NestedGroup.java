package io.github.lsikora.nested;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/*This class shows how to nest tests in JUnit 5. It creates possibilities for
 grouping certain types of test. One type of grouping that is applied here is
  technical grouping into testcases that are successful in business flow and
   those that are not*/
/*Great side effect of nesting test cases is also leveraging display name
functionality. This allows creating human readable tests*/
@DisplayName("This test is divided into:  ")
class NestedGroup {
    @DisplayName("Success case")
    @Nested
    class BusinessSuccess {
        @Test
        @DisplayName("I pass")
        void $() {
        }
    }

    @DisplayName("Fail case")
    @Nested
    class BusinessFail {
        @Test
        @DisplayName("I fail")
        void $() {
            fail("This test is designed to fail");
        }
    }
}
