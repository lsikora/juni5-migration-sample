package io.github.lsikora.conditional.junit4.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

@RunWith(Categories.class)
@Categories.IncludeCategory(Fast.class)
@org.junit.runners.Suite.SuiteClasses(JUnit4Categories.class)
public class Suite {
}
