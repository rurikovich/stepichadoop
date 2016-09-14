package cs_algo_theory_and_practice_methods.task8_2

import cs_algo_theory_and_practice_methods.task5_5.CsAlgo5_5__6
import spock.lang.Specification

/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo8_2__5Spec extends Specification {

    def "max rising sudquery works fine"() {
        expect:
        new CsAlgo8_2__5().process(convertIntegers(a)) == k

        where:
        a                        || k
        [3, 6, 7, 12]            || 3

    }

    private static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

}



