package io.github.lsikora.spock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static io.github.lsikora.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class JUnit5 {
    @TestFactory
    @DisplayName("Live long and prosper")
    Stream<DynamicTest> thisWillProduceDynamicTests() {
        return Stream.of(
                dynamicTest("First case", () -> assertNotEquals(APPLE, ORANGE)),
                dynamicTest("Second case", () -> assertNotEquals(PICKLE, GHERKIN))
        );
    }
}
