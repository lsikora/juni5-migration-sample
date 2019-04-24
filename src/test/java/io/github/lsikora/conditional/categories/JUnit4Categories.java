package io.github.lsikora.conditional.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JUnit4Categories {
    @Category(Fast.class)
    @Test
    public void shouldBeExecuted() {
    }

    @Test
    public void name() {
    }

}
