package cs_algo_theory_and_practice_methods.task5_5

import cs_algo_theory_and_practice_methods.task5_5.CsAlgo5_5__6
import spock.lang.Specification

/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo5_5__6Spec extends Specification {

    def "tests works fine"() {
        expect:
        new CsAlgo5_5__6().process(aArr, bArr, points) == res

        where:
        aArr   | bArr    | points     || res
        [0, 7] | [5, 10] | [1, 6, 11] || [1, 0, 0]
    }
}



