package io.github.lsikora.conditional.executioncondition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("This test shows how to filter test execution based on " +
        "ExecutionCondition feature in JUnit 5")
class WillNotRunDueToConditionAnnotation {

    @Test
    @DisabledOnIntOneEqualsStringOne
    @DisplayName("This test should not be executed. It is annotated " +
            "with execution condition which will always return false thus " +
            "filtering out this test execution")
    void disableOnConditionAnnotation() {
        throw new RuntimeException("This exception must never be thrown if " +
                "execution conditions work ;)");
    }
}
