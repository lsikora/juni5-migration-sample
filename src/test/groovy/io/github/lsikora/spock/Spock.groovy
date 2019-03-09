package io.github.lsikora.spock

import spock.lang.Specification
import spock.lang.Unroll

class Spock extends Specification {
    @Unroll
    def "Live long and prosper"(String left, String right) {
        expect:
        left != right

        where:
        left    | right
        "APPLE" | "ORRANGE"
        "PIKLE" | "GHERKIN"
    }
}
