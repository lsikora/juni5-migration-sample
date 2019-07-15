package io.github.lsikora.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

class GroovyScripting {
    @Test
    //todo point out to below snipper from JUnit 5.5 documentation
/*     @deprecated Script-based condition APIs and their supporting implementations
 are deprecated with the intent to remove them in JUnit Jupiter 5.6. Users
 should instead rely on a combination of other built-in conditions or create
 and use a custom implementation of
 {@link org.junit.jupiter.api.extension.ExecutionCondition ExecutionCondition}
 to evaluate the same conditions.*/
//todo enabled if is deprecated in 5.5 and to be removed in 5.6
    @EnabledIf(engine = "groovy", value = {
            "def name = 'Harry'",
            "def surname = 'Dirty'",
            "return name + surname == \"${name}${surname}\""
    })
    void willItRun() {
    }
}
