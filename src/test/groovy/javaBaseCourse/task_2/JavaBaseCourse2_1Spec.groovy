package javaBaseCourse.task_2

import spock.lang.Specification

import static javaBaseCourse.task_2.JavaBaseCourse2_1.*

/**
 * Created by rurik on 01.02.15.
 */

class JavaBaseCourse2_1Spec extends Specification {

    def "flipbit works fine"() {
        expect:
        flipBit(value, bitIndex) == res

        where:
        value | bitIndex || res
        0     | 1        || 1


    }

}
