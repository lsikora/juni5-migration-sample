package io.github.lsikora.conditional.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/*This class shows how to add category interface to JUnit 4 test. This allows
 to filter or group tests with given category when running JUnit 4 tests */
public class JUnit4Categories {
    @Category(Fast.class)
    @Test
    public void thisTestShouldBeExecutedWhenFastCategoryOfTestsShouldBeRun() {
    }

    @Test
    public void thisTestWillNotBeExecutedWhenOnlyFastJUnit4TestsShouldBeRun() {
    }

}
