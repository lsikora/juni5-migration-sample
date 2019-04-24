package io.github.lsikora.spock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.util.Random;
import java.util.stream.Stream;

import static io.github.lsikora.constants.Constants.*;
import static java.lang.Integer.MAX_VALUE;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class JUnit5 {
    private static final String MISERABLY = "miserably";

    @TestFactory
    Stream<DynamicTest> thisWillProduceDynamicRandomlyFailingTests() {
        var kindaEvil = new Random()
                .ints(1, 1, 8)
                .findFirst()
                .orElse(MAX_VALUE);

        //would be great to use var here and compiler shoud take Executable
        // from dynamicTest method signature since it is in same scope
        Executable assertion = switch (kindaEvil) {
            //would be great to get shorthand notation for -> () ->. Gets
            // long without ligatures
            case 1 -> () -> assertNotEquals(APPLE, ORANGE, MISERABLY);
            case 2 -> () -> assertNotEquals(PICKLE, GHERKIN, MISERABLY);
            default -> fail(MISERABLY);
        };

        return Stream.of(
                dynamicTest("First case", assertion)
        );
    }

    @TestFactory
    Stream<DynamicTest> thisWillProduceDynamicRandomlyFailingTests2() {
        var kindaEvil = new Random()
                .ints(1, 1, 8)
                .findFirst()
                .orElse(MAX_VALUE);

        //would be great to use var here and compiler would infer Executable
        // from dynamicTest method signature since it is in same scope
        Executable assertion = switch (kindaEvil) {
            //would be great to get shorthand notation for -> () ->. Gets
            // long without ligatures
            case 1 : break  () -> assertNotEquals(APPLE, ORANGE, MISERABLY);
            //good that there is compilation error when : and -> are used
            // together in one expression
            case 2 : break () -> assertNotEquals(PICKLE, GHERKIN, MISERABLY);

            default : break fail(MISERABLY);
        };

        return Stream.of(
                dynamicTest("First case", assertion)
        );
    }
}
