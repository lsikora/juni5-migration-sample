package io.github.lsikora.displaynamegen;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;

@DisplayNameGeneration(ReplaceUnderscores.class)
class GenerateDisplayNames {

    @Test
    void should_Be_Displayed_With_Generated_Display_Name() {
    }
}