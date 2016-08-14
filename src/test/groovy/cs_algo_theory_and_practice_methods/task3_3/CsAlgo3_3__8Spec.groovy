package cs_algo_theory_and_practice_methods.task3_3


import spock.lang.Specification

/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo3_3__8Spec extends Specification {

    def "tests works fine"() {
        expect:
        new CsAlgo3_3__8().process(commands) == res

        where:
        commands                                                                          || res
        ["Insert 200", "Insert 10", "ExtractMax", "Insert 5", "Insert 500", "ExtractMax"] || [200, 500]

    }


}



