package io.github.lsikora.parametrized;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.github.lsikora.constants.Food.Constants.APPLE_NAME;
import static io.github.lsikora.constants.Food.Constants.ORANGE_NAME;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*In bare JUnit 4 if we wanted to create parametrized test we were forced to
use ParametrizedRunner. Due to one runner per class constrain parametrization
 could not be used along with e.g Mockito or Spring*/
/*Using external library for test parametrization also required use of Runner
 in JUnit 4. But in case of library we do not have to create field and
 constructor to pass parameter. Also library gives more parametrization
 options*/
@RunWith(JUnitParamsRunner.class)
public class JUnit4Pragmatists {

    @Test
    @Parameters({ORANGE_NAME, APPLE_NAME})
    public void libraryParametrizedTest(String fruit) {
        assertTrue(!fruit.isBlank());
    }
}
