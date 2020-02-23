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

/*In bare JUnit 4 if we wanted to create parametrized test we were forced to
use ParametrizedRunner. Due to one runner per class constrain parametrization
 could not be used along with e.g Mockito or Spring*/
/*Also bare JUnit 4 parametrization required us to create field and
constructor to pass the parameter*/
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
