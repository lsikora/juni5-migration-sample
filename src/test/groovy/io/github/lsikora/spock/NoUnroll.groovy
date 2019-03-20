package io.github.lsikora.spock

import spock.lang.Specification
import spock.lang.Unroll

/*When this test is run with juni 4.12 it will contain 6 test cases
* same run with JUnit 5 Vintage engine will contain 2 test cases*/
class NoUnroll extends Specification {
    @Unroll
    def "#left is not same as #right"(Food left, Food right) {
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
