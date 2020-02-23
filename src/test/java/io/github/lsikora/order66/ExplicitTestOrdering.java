package io.github.lsikora.order66;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

/*Remember that you should not specify order at all. It is one of practices
that help you ran tests in parallel. Instead of ordering different setups can
 be used*/
/*Use ordering as las resort as seen in JUnit 5 guide*/
/*Although true unit tests typically should not rely on the order in which they are executed,
 there are times when it is necessary to enforce a specific test method execution order
  — for example, when writing integration tests or functional tests where the sequence
  of the tests is important, especially in conjunction with @TestInstance(Lifecycle.PER_CLASS).
  https://junit.org/junit5/docs/current/user-guide/#writing-tests-conditional-execution
  */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Tests in this class will be executed in configured order")
public class ExplicitTestOrdering {

    @Test
    @Order(2)
    @DisplayName("this test will be executed last")
    void declarationOrder0() {
    }

    @Test
    @Order(0)
    @DisplayName("this test will be executed first")
    void declarationOrder1() {
    }

    @Test
    @Order(1)
    @DisplayName("this test will be executed second")
    void declarationOrder2() {
    }
}
