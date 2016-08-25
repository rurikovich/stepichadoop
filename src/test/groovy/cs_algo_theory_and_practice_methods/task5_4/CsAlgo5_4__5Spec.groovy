package cs_algo_theory_and_practice_methods.task5_4

import spock.lang.Specification

/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo5_4__5Spec extends Specification {

    def "tests works fine"() {
        expect:
        new CsAlgo5_4__5().process(arr) == inv

        where:
        arr             || inv
        [2, 3, 9, 2, 9] || 2
    }


    def "merge works fine"() {
        new CsAlgo5_4__5().merge(lArr, rArr) == resArr
        where:
        lArr            | rArr      || resArr
        [1, 3, 4, 9]    | [2, 5, 6] || [1, 2, 3, 4, 5, 6, 9]
        [1, 3, 4]       | [1, 3, 4] || [1, 1, 3, 3, 4, 4]
        [1]             | []        || [1]
        []              | [1]       || [1]
        [9]             | [2, 3]    || [2, 3, 9]
        [1, 34, 55, 65] | [63, 67]  || [1, 34, 55, 63, 65, 67]

    }

    private static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

}



