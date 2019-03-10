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

@RunWith(MockitoJUnitRunner.class)
public class JUnit4 {
    @Mock
    private Object someObject;
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
