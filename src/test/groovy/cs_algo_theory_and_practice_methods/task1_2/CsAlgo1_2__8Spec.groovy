package cs_algo_theory_and_practice_methods.task1_2

import spock.lang.Specification

import static cs_algo_theory_and_practice_methods.task1_2.CsAlgo1_2__8.*


/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo1_2__8Spec extends Specification {

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
