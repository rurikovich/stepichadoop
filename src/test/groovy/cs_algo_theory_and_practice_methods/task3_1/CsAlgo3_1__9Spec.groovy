package cs_algo_theory_and_practice_methods.task3_1

import javafx.util.Pair
import spock.lang.Specification


/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo3_1__9Spec extends Specification {

    def "tests works fine"() {
        expect:
        CsAlgo3_1__9.process(segments) == res

        where:
        segments                                         || res
        [pair(1, 3), pair(2, 5), pair(3, 6)]             || [3]
        [pair(4, 7), pair(1, 3), pair(2, 5), pair(5, 6)] || [3, 6]


    }

    Pair pair(Integer a, Integer b) {
        return new Pair(a, b)
    }
}



