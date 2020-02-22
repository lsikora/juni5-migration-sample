package io.github.lsikora.parametrized;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.List;

import static io.github.lsikora.constants.Food.Constants.APPLE_NAME;
import static io.github.lsikora.constants.Food.Constants.ORANGE_NAME;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(Parameterized.class)
public class JUnit4 {
    public String fruit;

    public JUnit4(String fruit) {
        this.fruit = fruit;
    }

    @Parameters
    public static List<String> data() {
        return asList(ORANGE_NAME, APPLE_NAME);
    }

    @Test
    public void bareBonesJUnit4ParametrizedTest() {
        assertTrue(!fruit.isBlank());
    }
}
