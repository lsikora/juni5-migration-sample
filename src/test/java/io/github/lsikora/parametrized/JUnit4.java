package io.github.lsikora.parametrized;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.List;

import static io.github.lsikora.constants.Constants.APPLE;
import static io.github.lsikora.constants.Constants.ORANGE;
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
        return asList(ORANGE, APPLE);
    }

    @Test
    public void bareBonesJUnit4ParametrizedTest() {
        assertTrue(!fruit.isBlank());
    }
}
