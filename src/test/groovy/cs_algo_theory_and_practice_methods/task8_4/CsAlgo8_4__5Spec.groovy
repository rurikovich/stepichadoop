package cs_algo_theory_and_practice_methods.task8_4

import spock.lang.Specification

import static cs_algo_theory_and_practice_methods.test.utils.Helper.convertIntegers

/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo8_4__5Spec extends Specification {

    def "max sack weight works fine"() {
        expect:
        new CsAlgo8_4__5().process(weight, convertIntegers(w)) == res

        where:
        weight | w         || res
        10     | [1, 4, 8] || 9
        2      | [3, 2]    || 2


    }


}



