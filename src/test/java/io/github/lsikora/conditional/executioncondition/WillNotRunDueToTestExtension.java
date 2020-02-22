package io.github.lsikora.conditional.executioncondition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(IntOneEqualsStringOne.class)
@DisplayName("This test shows how to filter test execution based on " +
        "ExecutionCondition in JUnit 5")
class WillNotRunDueToTestExtension {
    @Test
    @DisplayName("This test method should not be executed. It is annotated " +
            "with execution condition which will always return false thus " +
            "filtering out this test execution")
    void disableOnSpecialTestExtension() {
        throw new RuntimeException("This exception must never be thrown if " +
                "execution conditions work ;)");
    }
}
