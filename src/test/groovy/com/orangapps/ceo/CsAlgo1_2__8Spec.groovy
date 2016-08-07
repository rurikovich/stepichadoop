package com.orangapps.ceo

import spock.lang.Specification


/**
 * Created by rurik on 01.02.15.
 */

class CsAlgo1_2__8Spec extends Specification {

    def "tests works fine"() {
        expect:
        CsAlgo1_2__8.process(n, m) == res

        where:
        n  | m || res
        10 | 2 || 1

    }

}
