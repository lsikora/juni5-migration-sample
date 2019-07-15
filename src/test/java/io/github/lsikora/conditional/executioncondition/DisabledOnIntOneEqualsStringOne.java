package io.github.lsikora.conditional.executioncondition;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, METHOD})
@Retention(RUNTIME)
//todo write to JUnit 5 guys. Example shows DisabledCondition and @Disabled
// annotation but copy pasting will not work. I had to add @ExtendWith here
// which is not present in @Disabled annotation
@ExtendWith(IntOneEqualsStringOne.class)
public @interface DisabledOnIntOneEqualsStringOne {
}
