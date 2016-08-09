package cs_algo_theory_and_practice_methods.task2_2

import cs_algo_theory_and_practice_methods.task2_3.CsAlgo2_3__5
import spock.lang.Specification


/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo2_3__5Spec extends Specification {

//    1≤n≤10^18  и 2≤ m ≤10^5
    def "tests works fine"() {
        expect:
        CsAlgo2_3__5.process(a, b) == res

        where:
        a        | b        || res
        18       | 35       || 1
        14159572 | 63967072 || 4


    }

}
