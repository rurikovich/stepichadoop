package cs_algo_theory_and_practice_methods.task8_3

import spock.lang.Specification

/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo8_3__8Spec extends Specification {

    def "eidting distance works fine"() {
        expect:
        new CsAlgo8_3__8().process(str1, str2) == k

        where:
        str1      | str2       || k
        "ab"      | "ab"       || 0
        "short"   | "ports"    || 3
        "editing" | "distance" || 5

    }


}



