package io.github.lsikora.extensions;

import com.github.rweisleder.jfairy.FairyExtension;
import com.github.rweisleder.jfairy.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.mockito.Mockito.doThrow;

@ExtendWith(FairyExtension.class)
@ExtendWith(MockitoExtension.class)
class JUnit5 {
    @Mock
    private Object someObject;
    @RegisterExtension
    private FiveMinuteExtension ext = new FiveMinuteExtension("Hakunamatata");

    @Test
    void shouldCheckException(@Random String message) {
        doThrow(new RuntimeException(message))
                .when(someObject).toString();
        assertTimeout(ofMillis(1),
                () -> {
                    assertThrows(
                            RuntimeException.class,
                            () -> someObject.toString());});
    }
}
