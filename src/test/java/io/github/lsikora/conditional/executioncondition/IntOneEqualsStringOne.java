package io.github.lsikora.conditional.executioncondition;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;

/*This is simple execution condition which will always disable the test*/
class IntOneEqualsStringOne implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        //todo Question on presentation? What is exact type of contextElement?
        // Optional<AnnotatedElement>.
        //As suggested by many and @SebastianRabiej at Wroclaw JUG. We should
        // not use var this way.
        var contextElement = context.getElement();
        return contextElement
                .map(e -> {
                    if (Integer.valueOf(1).equals("1"))
                        return enabled("Integer 1 is not equal to String one");
                    else return disabled("Integer 1 is equal to String one");
                })
                .orElse(enabled("@DisabledOnIntOneEqualsStringOne not found " +
                        "on element"));
    }
}
