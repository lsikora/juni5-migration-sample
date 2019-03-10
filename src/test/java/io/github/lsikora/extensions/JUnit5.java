package io.github.lsikora.extensions;

import com.github.rweisleder.jfairy.FairyExtension;
import com.github.rweisleder.jfairy.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doThrow;
import static org.testng.Assert.assertThrows;

@ExtendWith(FairyExtension.class)
@ExtendWith(MockitoExtension.class)
class JUnit5 {
    @Mock
    private Object someObject;
    @RegisterExtension
    FiveMinuteExtension ext = new FiveMinuteExtension("Hakunamatata");
    
    @Test
    void shouldCheckException(@Random String message) {
        doThrow(new RuntimeException(message))
                .when(someObject).toString();

       assertThrows(()-> someObject.toString());
    }
}
