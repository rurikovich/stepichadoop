package cs_algo_theory_and_practice_methods.task3_1

import spock.lang.Specification


/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo3_1__9Spec extends Specification {

    def "tests works fine"() {
        expect:
        CsAlgo3_1__9.process(segments) == res

        where:
        segments                 || res
        [1, 3, 2, 5, 3, 6]       || [3]
        [4, 7, 1, 3, 2, 5, 5, 6] || [3, 6]


    }

}
