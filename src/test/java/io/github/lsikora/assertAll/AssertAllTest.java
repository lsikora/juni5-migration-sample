package io.github.lsikora.assertAll;

import org.junit.jupiter.api.Test;

import static io.github.lsikora.constants.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AssertAllTest {
    @Test
    void assertAllAssertJAssertions() {
        assertAll(GLOBAL_MESSAGE, () -> {
            assertThat(VEGETABLE).isEqualTo(FRUIT);

            assertAll(
                  () -> assertThat(APPLE).isNotEqualTo(APPLE),
                  () -> assertThat(GHERKIN).isNotSameAs(PICKLE)
            );
        });
    }
}
