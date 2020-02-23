package io.github.lsikora.exceptions;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*Please remember that using given,when,then or arrange,act,assert comments
should be strongly prohibited. Well named library methods, and user code
should be giving this information right away. Those comments are here only to
 show that certain libraries do not keep order of gwt when asserting*/
@DisplayName("This test shows different approaches for checking thrown " +
        "exceptions")
class ExceptionHandling {
    static final String HERE_BE_DRAGONS = "Here be dragons";
    static final String EXCEPTION_NOT_THROWN = "Gone bad";

    //GIVEN
    static Runnable willThrowException() {
        return () -> {
            throw new RuntimeException(HERE_BE_DRAGONS);
        };
    }

    @Test
    @DisplayName("This is example of checking thrown exception with JUnit 5 " +
            "assertion. It will not check message in exception ")
    void assertThrowsAssertion() {
        assertThrows(
                RuntimeException.class,     //THEN
                willThrowException()::run,  //WHEN
                HERE_BE_DRAGONS             //THEN
        );
    }

    @Test
    @DisplayName("This is example of checking thrown exception with JUnit 5 " +
            "assertion. It will check message in exception ")
    void assertThrowsAssertionWithExceptionMessage() {
        RuntimeException runtimeException =
                assertThrows(
                        RuntimeException.class,     //THEN
                        willThrowException()::run,  //WHEN
                        EXCEPTION_NOT_THROWN        //THEN
                );
        //THEN
        assertEquals(HERE_BE_DRAGONS, runtimeException.getMessage());
    }

    @Test
    @DisplayName("This example shows that using external libraries is far " +
            "better than JUnit 5 assertThrows :(")
    void testBDDExceptionJUnit5ExceptionHandlingWithMessage() {
        //GIVEN
        var it = willThrowException();
        //WHEN
        when(it).run();
        //THEN
        then(caughtException())
                .isInstanceOf(RuntimeException.class)
                .hasMessage(HERE_BE_DRAGONS)
                .as(EXCEPTION_NOT_THROWN);
    }
}