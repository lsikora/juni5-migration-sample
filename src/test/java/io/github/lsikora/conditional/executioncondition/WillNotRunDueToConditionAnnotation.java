package io.github.lsikora.conditional.executioncondition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.condition.JRE.JAVA_9;
import static org.junit.jupiter.api.condition.OS.MAC;
import static org.junit.jupiter.api.condition.OS.SOLARIS;

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

    @EnabledOnOs({SOLARIS, MAC})
    @EnabledForJreRange(min = JAVA_9)
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    @DisabledIfEnvironmentVariable(named = "os.arch", matches = ".*64.*")
    @Test
    @DisplayName("This test may be run depending on embedded execution " +
            "conditions of JUnit 5")
    void embedded() {
    }
}
