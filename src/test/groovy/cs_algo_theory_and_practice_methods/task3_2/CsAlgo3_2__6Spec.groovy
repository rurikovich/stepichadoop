package cs_algo_theory_and_practice_methods.task3_2

import spock.lang.Specification

/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo3_2__6Spec extends Specification {

    def "tests works fine"() {
        expect:
        new CsAlgo3_2__6().process(str, encodedMap) == encodedStr

        where:
        str              | encodedMap                                    || encodedStr
        "0"              | ["a": "0"]                                    || "a"
        "01001100100111" | ["a": "0", "b": "10", "c": "110", "d": "111"] || "abacabad"

    }


}



