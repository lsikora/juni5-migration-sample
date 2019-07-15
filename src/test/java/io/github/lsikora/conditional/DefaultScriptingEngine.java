package io.github.lsikora.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.condition.JRE.JAVA_8;
import static org.junit.jupiter.api.condition.OS.MAC;

class DefaultScriptingEngine {

    @Test
    @EnabledOnOs(MAC)
    @DisabledOnJre(JAVA_8)
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    @DisabledIfSystemProperty(named = "ci-server", matches = "true")
    //todo point out to below snipper from JUnit 5.5 documentation
/*     @deprecated Script-based condition APIs and their supporting implementations
 are deprecated with the intent to remove them in JUnit Jupiter 5.6. Users
 should instead rely on a combination of other built-in conditions or create
 and use a custom implementation of
 {@link org.junit.jupiter.api.extension.ExecutionCondition ExecutionCondition}
 to evaluate the same conditions.*/
//todo enabled if is deprecated in 5.5 and to be removed in 5.6
    @EnabledIf("1 === \"1\" ")
    void willItRun() {
    }

}
