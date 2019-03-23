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
    @EnabledIf("1 === \"1\" ")
    void willItRun() {
    }

}
