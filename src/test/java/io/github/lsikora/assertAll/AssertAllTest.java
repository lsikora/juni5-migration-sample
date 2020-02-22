package io.github.lsikora.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.github.lsikora.constants.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Tests in this class show assertAll assertion and its nesting " +
        "behaviour")
class AssertAllTest {
    @Test
    @DisplayName("When assertions in are wrapped in assertAll they must all " +
            "pass but each failure will be reported separately")
    void assertAllAssertion() {
        assertAll(GLOBAL_MESSAGE,
                () -> assertThat(APPLE).isEqualTo(PICKLE),
                () -> assertThat(GHERKIN).isNotSameAs(GHERKIN)
        );
    }

    @Test
    @DisplayName("When assertAll assertions are nested simple assertion " +
            "is precondition nested assertAll execution")
    void assertAllNestWithPrecondition() {
        assertAll(GLOBAL_MESSAGE, () -> {
            assertThat(VEGETABLE).isEqualTo(FRUIT);

            assertAll(
                    () -> assertThat(APPLE).isEqualTo(APPLE),
                    () -> assertThat(GHERKIN).isNotSameAs(PICKLE)
            );
        });
    }
}
