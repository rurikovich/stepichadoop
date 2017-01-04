package javaBaseCourse.task_2

import spock.lang.Specification

import static javaBaseCourse.task_2.JavaBaseCourse2_2__3.*

/**
 * Created by rurik on 01.02.15.
 */

class JavaBaseCourse2_2__3Spec extends Specification {

    def "charExpression works fine"() {
        expect:
        charExpression(a) == res

        where:
        a  || res
        32 || '|'
        29 || 'y'

    }

}
