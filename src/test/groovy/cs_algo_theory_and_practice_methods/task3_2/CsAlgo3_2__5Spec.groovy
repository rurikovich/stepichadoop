package cs_algo_theory_and_practice_methods.task3_2

import spock.lang.Specification

/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo3_2__5Spec extends Specification {

    def "tests works fine"() {
        expect:
        CsAlgo3_2__5.process(str) == encodedStr

        where:
        str        || encodedStr
        "a"        || "0"
        "k"        || "0"
        "ab"       || "01"
        "aaaaa"    || "00000"
        "abacabad" || "01001100100111"


    }


}



