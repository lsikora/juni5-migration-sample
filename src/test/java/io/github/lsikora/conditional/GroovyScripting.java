package io.github.lsikora.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

class GroovyScripting {
    @Test
    @EnabledIf(engine = "groovy", value = {
            "def name = 'Harry'",
            "def surname = 'Dirty'",
            "return name + surname == \"${name}${surname}\""
    })
    void willItRun() {
    }
}
