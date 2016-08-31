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


    def "partition works fine"() {
        expect:
        new CsAlgo5_5__6().partition(arr, 0, arr.size() - 1) == m

        where:
        arr                       || m
        [7, 1, 9, 4, 12, 6, 2, 9] || 4
        [7, 1]                    || 1
        [4, 3, 4, 5, 6, 7, 2]     || 3
        [4, 5, 5, 6]              || 0
        [4, 4, 4, 4]              || 3
    }

    def "quickSort works fine"() {
        expect:
        new CsAlgo5_5__6().quickSort(arr) == sortedArr

        where:
        arr                || sortedArr
        [1, 3, 2, 4, 5, 2] || [1, 2, 2, 3, 4, 5]
        [6, 5, 4, 3, 2, 1] || [1, 2, 3, 4, 5, 6]
    }
}



