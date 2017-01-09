package javaBaseCourse.task5_3

import spock.lang.Specification

import static javaBaseCourse.task_2.JavaBaseCourse2_1.flipBit

/**
 * Created by rurik on 01.02.15.
 */

class JavaBaseCourse5_3__13Spec extends Specification {

    def "sum works fine"() {
        expect:
        flipBit(value, bitIndex) == res

        where:
        value | bitIndex || res
        0     | 1        || 1


    }

}
