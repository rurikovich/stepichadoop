package cs_algo_theory_and_practice_methods.task3_1

import javafx.util.Pair
import spock.lang.Specification


/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo3_1__10Spec extends Specification {

    def "tests works fine"() {
        expect:
        CsAlgo3_1__10.process(ww, things) == res

        where:
        ww | things                                       || res
//        50 | [pair(60, 20), pair(100, 50), pair(120, 30)] || 180.000d
        25 | [pair(250, 23), pair(120, 11)]               || 272.17391304347825d

    }

    Pair pair(Integer a, Integer b) {
        return new Pair(a, b)
    }
}



