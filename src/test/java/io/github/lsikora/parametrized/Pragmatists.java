package io.github.lsikora.parametrized;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.github.lsikora.constants.Constants.APPLE;
import static io.github.lsikora.constants.Constants.ORANGE;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class Pragmatists {

    @Test
    @Parameters({ORANGE, APPLE})
    public void libraryParametrizedTest(String fruit) {
        assertTrue(!fruit.isBlank());
    }
}
