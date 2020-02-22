package io.github.lsikora.parametrized;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.github.lsikora.constants.Food.Constants.APPLE_NAME;
import static io.github.lsikora.constants.Food.Constants.ORANGE_NAME;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class Pragmatists {

    @Test
    @Parameters({ORANGE_NAME, APPLE_NAME})
    public void libraryParametrizedTest(String fruit) {
        assertTrue(!fruit.isBlank());
    }
}
