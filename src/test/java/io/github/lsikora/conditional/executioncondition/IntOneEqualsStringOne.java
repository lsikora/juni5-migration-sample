package io.github.lsikora.conditional.executioncondition;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;

class IntOneEqualsStringOne implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        //todo zagadka? jakiego typu jest e? Optional<AnnotatedElement>.
        //w takich wypadkach nie wolno używać var!!! @SebastianRabiej
        var contextElement = context.getElement();
        return contextElement
                .map(e -> {
                    if (Integer.valueOf(1).equals("1"))
                        return enabled("Integer 1 is not equal to string one");
                    else return disabled("Integer 1 is equal to string one");
                })
                .orElse(enabled("@DisabledOnIntOneEqualsStringOne not found " +
                        "on element"));
    }
}
