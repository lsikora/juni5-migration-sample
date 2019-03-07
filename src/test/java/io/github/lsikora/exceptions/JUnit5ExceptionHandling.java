package io.github.lsikora.exceptions;


import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static io.github.lsikora.exceptions.JUnit4ExceptionHandling.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JUnit5ExceptionHandling {

    private static final String WHICH_MESSAGE_WILL_IT_BE = "Which message will it be?";

    @Test
    void testNativeJUnit5ExceptionHandlingWithMessage0() {
        assertThrows(
                RuntimeException.class,     //THEN
                willThrowException()::run,  //WHEN
                HERE_BE_DRAGONS             //THEN
        );
    }

    //will throw exception
    @Test
    void assertEqualsTest() {
        assertEquals(1,2,"This is not equal");
    }

    //will throw exception
    @Test
    void testNativeJUnit5ExceptionHandlingWithMessage1() {
        //          //THEN                   //WHEN  //WHEN ASSERTION FAILS
        assertThrows(RuntimeException.class, () -> {
        }, WHICH_MESSAGE_WILL_IT_BE);
    }

    @Test
    void testNativeJUnit5ExceptionHandlingWithMessage() {
        RuntimeException runtimeException =
                assertThrows(
                        RuntimeException.class,     //THEN
                        willThrowException()::run,  //THEN
                        EXCEPTION_NOT_THROWN        //THEN
                );
        //THEN
        assertEquals(HERE_BE_DRAGONS, runtimeException.getMessage());
    }

    @Test
    void testNativeJUnit5ExceptionHandlingWithMessageAndBddAssertions() {
        RuntimeException runtimeException =
                assertThrows(
                        RuntimeException.class,     //THEN
                        willThrowException()::run,  //THEN
                        EXCEPTION_NOT_THROWN        //THEN
                );
        //THEN
        assertEquals(HERE_BE_DRAGONS, runtimeException.getMessage());
    }

    @Test
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