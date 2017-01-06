package javaBaseCourse.task_2_3;

import java.util.Scanner;

/**
 * Created by User on 04.01.2017.
 */
public class JavaBaseCourse2_3__10 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String text = reader.next();
        System.out.print(isPalindrome(text));
    }


    public static boolean isPalindrome(String text) {
        StringBuilder t = new StringBuilder(text.replaceAll("[^a-zA-Z0-9]", ""));
        String s = t.toString().toLowerCase();
        return s.equals(t.reverse().toString().toLowerCase());
    }

}
