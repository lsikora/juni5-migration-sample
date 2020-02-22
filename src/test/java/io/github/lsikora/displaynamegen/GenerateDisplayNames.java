package io.github.lsikora.displaynamegen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;

/*This test will create human readable description based on snake case.
Sadly camelcase version of DisplayNameGenerator is being hold when it should
pass given it covers most common cases https://github.com/junit-team/junit5/issues/1595*/
@DisplayNameGeneration(ReplaceUnderscores.class)
@DisplayName("This test shows that projects which use snake case can already " +
        "have human readable test output")
class GenerateDisplayNames {

    @Test
    void this_test_shows_that_JUnit5_converts_snake_case_to_human_readable_with_correct_setup() {
    }
}