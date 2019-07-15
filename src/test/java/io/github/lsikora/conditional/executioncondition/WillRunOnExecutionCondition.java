package io.github.lsikora.conditional.executioncondition;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(IntOneEqualsStringOne.class)
class WillRunOnExecutionCondition {

    @Test
    @DisabledOnIntOneEqualsStringOne
    void thisMethodShouldBeDisabledEnabledThanksToAnnotation() {
        throw new RuntimeException("This exception must never be thrown if " +
                "execution conditions work");
    }

    @Test
    void thisMethodShouldBeDisabledThanksToExecutionConditionExtension() {
        throw new RuntimeException("This exception must never be thrown if " +
                "execution conditions work");
    }
}
