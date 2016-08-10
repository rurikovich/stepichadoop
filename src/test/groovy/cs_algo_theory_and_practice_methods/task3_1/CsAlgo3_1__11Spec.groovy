package cs_algo_theory_and_practice_methods.task3_1

import javafx.util.Pair
import spock.lang.Specification


/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo3_1__11Spec extends Specification {

    def "tests works fine"() {
        expect:
        CsAlgo3_1__11.process(n) == res

        where:
        n          || res
        4          || [1, 3]
        6          || [1, 2, 3]
        1          || [1]
//        1000000000 || [1]


    }

    Pair pair(Integer a, Integer b) {
        return new Pair(a, b)
    }
}



