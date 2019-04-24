package io.github.lsikora.conditional.tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

class JUnit5Tags {
    @Test
    @Tag("Fast")
    void fastRun() {}

    @Slow
    void slowRun() {}

    @Test
    void shouldNotBeRun() {}

    @Target({ TYPE, METHOD })
    @Retention(RUNTIME)
    @Tag("Slow")
    @Test
    public @interface Slow {}
}
