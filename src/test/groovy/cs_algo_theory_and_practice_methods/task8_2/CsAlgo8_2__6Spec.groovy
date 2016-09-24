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
        a                                           || sudquery
//        [1, 3, 5, 6, 7, 4, 8, 2, 9]                 || [7, 4, 2]
//        [5, 3, 4, 4, 2]                             || [5, 4, 4, 2]
//        [1, 2, 3, 4, 5]                             || [5]
//        [5, 4, 3, 2, 1]                             || [5, 4, 3, 2, 1]
//        [5, 5, 5, 5, 5, 1]                          || [5, 5, 5, 5, 5, 1]
//        [5, 5, 5, 5, 5]                             || [5, 5, 5, 5, 5]
//        [1000000000, 1, 3, 50000, 400, 10, 9, 8, 0] || [1000000000, 50000, 400, 10, 9, 8, 0]
//        [7, 6, 1, 6, 4, 1, 2, 4, 10, 1]             || [7, 6, 6, 4, 4, 1]
//        [1, 3, 3, 2, 1, 2, 3, 2, 3, 3]              || [3, 3, 2, 2, 2]
//        [1]                                         || [1]
//        [1, 2]                                      || [2]
//        [2, 1]                                      || [2, 1]
//        [1, 1]                                      || [1, 1]
        [9, 10, 6, 3, 6, 8, 7, 9, 6, 5]             || [10, 6, 6, 6, 5]


    }


    private static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

}



