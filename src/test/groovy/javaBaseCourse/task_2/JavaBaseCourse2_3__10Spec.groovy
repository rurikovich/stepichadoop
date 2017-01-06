package javaBaseCourse.task_2

import spock.lang.Specification

import static javaBaseCourse.task_2_3.JavaBaseCourse2_3__10.isPalindrome

/**
 * Created by rurik on 01.02.15.
 */

class JavaBaseCourse2_3__10Spec extends Specification {

    def "isPalindrome works fine"() {
        expect:
        isPalindrome(text) == res

        where:
        text || res
        "Madam, I'm Adam!"    || true

    }

}
