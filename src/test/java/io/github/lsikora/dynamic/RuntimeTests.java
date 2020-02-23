package io.github.lsikora.dynamic;

import io.github.lsikora.dynamic.testtemplateprovider.FruitNameProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.stream.Stream;

import static io.github.lsikora.constants.Food.*;
import static java.util.stream.Stream.of;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@DisplayName("Those tests will be created in runtime with same test " +
        "lifecycle for each test")
/*Do keep in mind that tests in this class are simple implementations.
Dynamic test can be used e.g. to factorize test depending on some internal
framework or custom file type (Although it might be beneficial to invest some
 time into creation of own test engine)*/
class RuntimeTests {
    @TestFactory
    @DisplayName("It will create two separate tests based on factory method")
    Stream<DynamicTest> useTestFactory() {
        return of(
                dynamicTest("Comparing apples to oranges",
                        () -> assertNotEquals(APPLE, ORANGE)
                ),
                dynamicTest("Comparing pickles to gherkins",
                        () -> assertNotEquals(PICKLE, GHERKIN)
                )
        );
    }

    @TestTemplate
    @ExtendWith(FruitNameProvider.class)
    @DisplayName("This shows off example of dynamic test creation")
    void useTestTemplate(String fruit) {
        assertNotEquals(GHERKIN.name(), fruit);
    }
}
