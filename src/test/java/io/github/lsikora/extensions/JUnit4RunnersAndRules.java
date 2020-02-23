package io.github.lsikora.extensions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.rules.ExpectedException.none;
import static org.junit.rules.Timeout.millis;
import static org.mockito.Mockito.doThrow;

/*This class shows programmatic extension capabilities of JUnit 4*/
/*There can be only one ... runner for test in JUnit 4*/
@RunWith(MockitoJUnitRunner.class)
public class JUnit4RunnersAndRules {
    @Mock
    private Object someObject;
    /*Multiple @Rule can be used in single test. But this is second extension
     mechanism in JUnit 4. Runners and rules are not compatible with each
     other, different interfaces have to be implemented for them*/
    @Rule
    public ExpectedException expectedEx = none();
    @Rule
    public Timeout timeout = millis(3L);

    @Test
    public void shouldCheckException() {
        doThrow(new RuntimeException("Here be dragons"))
                .when(someObject).toString();
        expectedEx.expect(RuntimeException.class);

        someObject.toString();
    }

    @Test
    public void willNotTimeout() {
    }
}
