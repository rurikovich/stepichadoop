package javaBaseCourse.task_2

import spock.lang.Specification

import static javaBaseCourse.task_2.JavaBaseCourse2_2__9.isPowerOfTwo

/**
 * Created by rurik on 01.02.15.
 */

class JavaBaseCourse2_2__9Spec extends Specification {

    def "isPowerOfTwo works fine"() {
        expect:
        isPowerOfTwo(value) == res

        where:
        value || res
        2     || true
        16    || true
        -32   || true
        14    || false

    }

}
