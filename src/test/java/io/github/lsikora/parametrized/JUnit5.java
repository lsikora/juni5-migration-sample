package io.github.lsikora.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Period;
import java.util.Currency;

import static io.github.lsikora.constants.Constants.APPLE;
import static io.github.lsikora.constants.Constants.ORANGE;
import static io.github.lsikora.parametrized.Food.GHERKIN;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

class JUnit5 {

    @ParameterizedTest
    @ValueSource(strings = {ORANGE, APPLE})
    void pureJunitParametrizedTest(String fruit) {
        assertTrue(!fruit.isBlank());
    }

    //add notation about this warning
    @ParameterizedTest
    //todo explicit boolean is now supported, why not enum still
    @ValueSource(booleans = true)
    @MethodSource

    //todo explaing new empty value
    @CsvSource(value = {"JPY", "PLN"}, emptyValue = "")
    @CsvFileSource(resources = "somefile.csv", emptyValue = "")
    @EnumSource(Food.class)
//    @EmptySource
//    @NullSource
//    @NullAndEmptySource
    void allSources() {
    }

    @ParameterizedTest
    @CsvSource({"JPY", "PLN"})
    void automaticConversion(Currency currency) {
        assertNotNull(currency);
    }

    @ParameterizedTest
    @CsvSource("P1D")
    void automaticConversionTime(Period period) {

        assertNotNull(period);
    }

    @ParameterizedTest
    @EnumSource(mode = EXCLUDE,
            value = Food.class,
            names = "GHERKIN")
    void willExcludeGherkin(Food food) {
        assertNotSame(GHERKIN, food);
    }

}
