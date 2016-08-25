package cs_algo_theory_and_practice_methods.task5_1

import spock.lang.Specification

/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo5_1__4Spec extends Specification {

    def "tests works fine"() {
        expect:
        new CsAlgo5_1__4().process(sortedArr, arrToTest) == indexes

        where:
        sortedArr                       | arrToTest         || indexes
        [1, 5, 8, 12, 13]               | [8, 1, 23, 1, 11] || [3, 1, -1, 1, -1]
        [1, 5, 8, 12, 13]               | [1, 5, 8, 12, 13] || [1, 2, 3, 4, 5]
        [1, 5, 8, 12, 13, 100000]       | [100000]          || [6]
        [1, 5, 8, 12, 13, 20, 100000]   | [13]              || [5]
        [10, 15, 18, 20, 99998, 100000] | [3, 99998]        || [-1, 5]
        [10, 15, 18, 20, 1000000000]    | [1000000000]      || [5]
        [10]                            | [10, 19]          || [1, -1]
        [1000000000]                    | [1000000000]      || [1]


    }


    def "Big test works fine"() {
        expect:
        new CsAlgo5_1__4().process(sortedArr, arrToTest) == indexes

        where:
        sortedArr      | arrToTest      || indexes
        getFullArray() | getFullArray() || getIndexes()
    }


    int[] getFullArray() {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = i * 1000;
        }
        return arr;
    }

    int[] getIndexes() {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }


}



