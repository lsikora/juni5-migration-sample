package io.github.lsikora.conditional.categories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/*This suite will only run tests with Fast category when executed*/
@RunWith(Categories.class)
@IncludeCategory(Fast.class)
@SuiteClasses(JUnit4Categories.class)
public class JUnit4Suite {
}
