package javaBaseCourse.task_2;

import java.util.Scanner;

/**
 * Created by User on 04.01.2017.
 */
public class JavaBaseCourse2_1 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int value = reader.nextInt();
        int bitIndex = reader.nextInt();
        System.out.print(flipBit(value, bitIndex));
    }


    public static int flipBit(int value, int bitIndex) {
        int bitIndexValue = 1 << (bitIndex-1);
        return value ^ bitIndexValue;
    }

}
