package cs_algo_theory_and_practice_methods.task5_5

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


    def "partitionInt works fine"() {
        expect:
        new CsAlgo5_5__6().partitionInt(arr, 0, arr.size() - 1) == m

        where:
        arr                                || m
        [7, 1, 9, 7, 12, 6, 7, 2, 7, 9, 1] || 4

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



