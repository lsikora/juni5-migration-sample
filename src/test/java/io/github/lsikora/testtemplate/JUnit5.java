package io.github.lsikora.testtemplate;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.github.lsikora.parametrized.Food.GHERKIN;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class JUnit5 {

    @TestTemplate
    @ExtendWith(FruitNameProvider.class)
    void willProcessAllFruits(String fruit) {
        assertNotEquals(GHERKIN.name(), fruit);
    }

}
