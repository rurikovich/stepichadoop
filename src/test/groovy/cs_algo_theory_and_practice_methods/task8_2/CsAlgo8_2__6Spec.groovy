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
        a                                                                                                                                                                                                                                                                                                                                                                                                 || sudquery
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
//        [9, 10, 6, 3, 6, 8, 7, 9, 6, 5]                                                                                                                                                                                                                                                                                                                                                                   || [10, 6, 6, 6, 5]
        [64, 80, 90, 69, 23, 78, 30, 76, 11, 2, 7, 42, 13, 45, 40, 52, 31, 42, 33, 74, 37, 64, 2, 26, 88, 51, 53, 95, 26, 7, 58, 9, 30, 29, 53, 69, 3, 71, 40, 89, 32, 90, 14, 49, 18, 70, 37, 79, 6, 48, 25, 28, 7, 81, 35, 99, 1, 1, 28, 17, 56, 77, 11, 64, 28, 6, 9, 62, 32, 2, 31, 29, 23, 50, 89, 95, 54, 36, 13, 52, 77, 58, 80, 58, 21, 20, 1, 82, 27, 31, 84, 14, 73, 55, 2, 69, 95, 33, 70, 72] || []


    }


    private static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

}



