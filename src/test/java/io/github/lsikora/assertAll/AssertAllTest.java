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

    private class Basket{
        private final String apple = APPLE;
        private final String orange = ORANGE;
        private final String gherkin = GHERKIN;
        private final String pickle = PICKLE;

        public String getApple() {
            return apple;
        }

        public String getOrange() {
            return orange;
        }

        public String getGherkin() {
            return gherkin;
        }

        public String getPickle() {
            return pickle;
        }
    }
}
