package io.github.lsikora.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.ExpectedException;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.BDDAssertions.then;

/*Please remember that using given,when,then or arrange,act,assert comments
should be strongly prohibited. Well named library methods, and user code
should be giving this information right away. Those comments are here only to
 show that certain libraries do not keep order of gwt when asserting*/
@DisplayName("This test shows different approaches for checking thrown " +
        "exceptions in JUnit 4")
public class JUnit4ExceptionHandling {
    static final String HERE_BE_DRAGONS = "Here be dragons";
    static final String EXCEPTION_NOT_THROWN = "Gone bad";

    static Runnable willThrowException() {
        return () -> {
            throw new RuntimeException(HERE_BE_DRAGONS);
        };
    }

    /*We have no way of checking exception message or more importantly cause
    if using JUnit 4 this way*/
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

    /*Using ExpectedException rule is not readable. It mixes gwt order in
    entire test method*/
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

    /*Using external libraries is the best way of checking exceptions in
    JUnit 4*/
    @Test
    public void testBDDExceptionJUnit4ExceptionHandlingWithMessage() {
        //GIVEN
        var it = willThrowException();
        //WHEN
        when(it).run();
        //THEN
        then(caughtException())
                .isInstanceOf(RuntimeException.class)
                .hasMessage(HERE_BE_DRAGONS)
                //slide2
                .as(EXCEPTION_NOT_THROWN);
    }
}