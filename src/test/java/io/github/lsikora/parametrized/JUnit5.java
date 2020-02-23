package io.github.lsikora.parametrized;

import io.github.lsikora.constants.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Period;
import java.util.Currency;

import static io.github.lsikora.constants.Food.Constants.APPLE_NAME;
import static io.github.lsikora.constants.Food.Constants.ORANGE_NAME;
import static io.github.lsikora.constants.Food.GHERKIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

@DisplayName("This class shows different parametrization capabilities in " +
        "JUnit 5:")
class JUnit5 {

    @ParameterizedTest
    @ValueSource(strings = {ORANGE_NAME, APPLE_NAME})
    /*Sources below can be used in combination with other types of sources.
    They work with context of parameter type. E.g producing empty String or
    empty Optional*/
    @EmptySource
    @NullSource
    @NullAndEmptySource
    @DisplayName("How to parametrize by using @ValueSource")
    void pureJunitParametrizedTest(String fruit) {
        assertThat(!fruit.isBlank()).isTrue();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/currencies.csv")
    @DisplayName("How to parametrize by using .csv file")
    void csvFileSource(String currency) {
        assertNotNull(currency);
    }

    @ParameterizedTest
    /*This test should not execute properly and IDE creates warning so long
    as a method that meets requirements for parametrization is not
    implemented*/
    @MethodSource
    @DisplayName("How to parametrize test with values coming " +
            "from method")
    void methodSource(String fruit) {
        assertThat(!fruit.isBlank()).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"JPY", "PLN"}, emptyValue = "")
    @DisplayName("How to parametrize test with values coming " +
            "from csv in annotation")
    void automaticConversion(Currency currency) {
        assertNotNull(currency);
    }

    @ParameterizedTest
    @CsvSource("P1D")
    @DisplayName("How to use implicit conversion in JUnit 5")
    void automaticConversionTime(Period period) {

        assertNotNull(period);
    }

    @ParameterizedTest
    @EnumSource(
            value = Food.class,
            mode = EXCLUDE,
            names = "GHERKIN"
    )
    @DisplayName("How to use parametrize test with enum values")
    void willExcludeGherkin(Food food) {
        assertNotSame(GHERKIN, food);
    }

}
