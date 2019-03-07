package io.github.lsikora.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.BDDAssertions.then;

public class JUnit4ExceptionHandling {
    static final String HERE_BE_DRAGONS = "Here be dragons";
    static final String EXCEPTION_NOT_THROWN = "Gone bad";

    //THEN
    @Test(expected = RuntimeException.class)
    public void testNativeJUnit4ExceptionHandlingWithoutMessage() {
        //GIVEN
        var it = willThrowException();
        //WHEN
        it.run();
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testNativeJUnit4ExceptionHandlingWithMessage() {
        //GIVEN
        var it = willThrowException();
        //THEN
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage(HERE_BE_DRAGONS);
        expectedEx.reportMissingExceptionWithMessage(EXCEPTION_NOT_THROWN);
        //WHEN
        it.run();
    }

    @Test
    public void testBDDExceptionJUnit4ExceptionHandlingWithMessage() {
        //GIVEN
        var it = willThrowException();
        //WHEN
        when(it).run();
        //THEN
        //slide1
        then(caughtException())
                .isInstanceOf(RuntimeException.class)
                .hasMessage(HERE_BE_DRAGONS)
                //slide2
                .as(EXCEPTION_NOT_THROWN);
    }

    static Runnable willThrowException() {
        return () -> {
            throw new RuntimeException(HERE_BE_DRAGONS);
        };
    }
}