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
        str                         || encodedStr
        "a"                         || "0"
        "k"                         || "0"
        "ab"                        || "01"
        "aaaaa"                     || "00000"
        "abacabad"                  || "01001100100111"
        "beep boop beer!"           || "0011110101000001101101010000111110101011"
        "aaassssdddddffffffggggggg" || "110110110111111111111000000000001010101010110101010101010"


    }


}



