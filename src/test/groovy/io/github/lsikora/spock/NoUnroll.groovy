package io.github.lsikora.spock

import org.junit.jupiter.api.DisplayName
import spock.lang.Specification
import spock.lang.Unroll

/* When this test is run with JUnit 4.12 it will contain 6 test cases
same run with JUnit 5 Vintage engine 5.2 will contain 2 test cases
same run with JUnit 5 Vintage engine 5.5 will contain 4 test cases */

class NoUnroll extends Specification {
    @Unroll
    def " Comparing #left to #right"(Food left, Food right) {
        expect:
        !left.equals(right)

        where:
        left                | right
        new Food("APPLE")   | new Food("ORANGE")
        new Food("ORANGE")  | null
        new Food("ORANGE")  | ""
        new Food("GHERKIN") | new Food(null)
        new Food("ORANGE")  | new Object()
    }

    class Food {
        String name

        Food(String name) {
            this.name = name
        }


        @Override
        String toString() {
            return "Food{" +
                    "name='" + name + '\'' +
                    '}'
        }
    }
}
