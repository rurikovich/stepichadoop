package javaBaseCourse.task_2;

import java.util.Scanner;

/**
 * Created by User on 04.01.2017.
 */
public class JavaBaseCourse2_2__3 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int a = reader.nextInt();
        System.out.print(charExpression(a));
    }


    public static char charExpression(int a) {
        return (char)((int)'\\'+a);
    }

}
