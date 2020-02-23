package io.github.lsikora.extensions;

import com.github.rweisleder.jfairy.FairyExtension;
import com.github.rweisleder.jfairy.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.mockito.Mockito.doThrow;

/*Multiple extensions can be applied on class level which is upgrade from
single JUnit 4 runner*/
@ExtendWith(FairyExtension.class)
@ExtendWith(MockitoExtension.class)
@DisplayName("This test shows different approaches of applying extensions to " +
        "your test")
class Extensions {
    @Mock
    private Object someObject;
    /*Same extension mechanism is used in entire JUnit 5*/
    /*Ide does not give a warning but test will fail so long as this field
    remains private*/
    @RegisterExtension
    private FiveMinuteExtension ext = new FiveMinuteExtension("Hakunamatata");

    @Test
    @DisplayName("This test will not execute properly so long as field " +
            "annotated with @RegisterExtension is private")
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
