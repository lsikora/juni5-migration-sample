package io.github.lsikora.conditional.tags;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/*How to make JUnit 5 include or exclude only certain tags depends on runtime
 environment. E.g  in IntelliJ Idea test kind in run configuration has to be
 changed to "Tag" and correct "Tag Expression" has to be set. In Gradle
 useJUnitPlatform{
    includeTags 'Fast', 'Slow'
 }
 has to be set where "Fast" and "Slow" are example tag discriminators
 */
@DisplayName("This class shows how to use @Tag annotation in JUnit 5 to " +
        "filter out tests which should not be executed")
class Tags {
    @Test
    @Tag("Fast")
    @DisplayName("This test should only run when tests with @Tag(\"Fast\") " +
            "are enabled")
    void fastRun() {
    }

    @Slow
    @DisplayName("This test should only run when tests with @Tag(\"Slow\") " +
            "are enabled")
    void slowRun() {
    }

    @Test
    @DisplayName("This test should not run when explicit tags are specified " +
            "for test execution")
    void shouldNotBeRun() {
    }

    /*This is marker interface which helps with adding @Tag annotation to
    multiple tests. Since @Tag annotation takes a value of String.class this
    annotation helps in keeping that string discriminator in one place*/
    @Target({TYPE, METHOD})
    @Retention(RUNTIME)
    @Tag("Slow")
    @Test
    public @interface Slow {
    }
}
