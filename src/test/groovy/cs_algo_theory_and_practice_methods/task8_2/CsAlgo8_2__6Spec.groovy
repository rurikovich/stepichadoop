package cs_algo_theory_and_practice_methods.task8_2

import spock.lang.Specification

/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo8_2__6Spec extends Specification {

    def "max rising sudquery works fine"() {
        expect:
        new CsAlgo8_2__6().process(convertIntegers(a)) == convertIntegers(subA)

        where:
        a               || subA
        [5, 3, 4, 4, 2] || [1, 3, 4, 5]

    }


    def "processNLogN works fine"() {
        expect:
        new CsAlgo8_2__6().processNLogN(convertIntegers(a)) == convertIntegers(sudquery)

        where:
        a                           || sudquery
        [1, 3, 5, 6, 7, 4, 8, 2, 9] || [1, 2, 3, 4, 5, 7, 9]
        [5, 3, 4, 4, 2]             || [1, 3, 4, 5]

    }


    private static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

}



