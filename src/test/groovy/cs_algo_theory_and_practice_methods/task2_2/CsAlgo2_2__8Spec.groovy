package cs_algo_theory_and_practice_methods.task2_2

import spock.lang.Specification

import static CsAlgo2_2__8.*


/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo2_2__8Spec extends Specification {

//    1≤n≤10^18  и 2≤ m ≤10^5
    def "tests works fine"() {
        expect:
        process(n, m) == res

        where:
        n  | m || res
        10 | 2 || 1
        1  | 9 || 1
        1  | 9 || 1


    }

}
