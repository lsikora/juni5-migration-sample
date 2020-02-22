package io.github.lsikora.conditional.executioncondition;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/*This annotation is used to run test only when IntOneEqualsStringOne
condition is met. This should always fail as it just returns Integer.valueOf(1).equals("1")*/
@Target({TYPE, METHOD})
@Retention(RUNTIME)
@ExtendWith(IntOneEqualsStringOne.class)
public @interface DisabledOnIntOneEqualsStringOne {
}
