package javaBaseCourse.task_2;

import java.util.Scanner;

/**
 * Created by User on 04.01.2017.
 */
public class JavaBaseCourse2_2__9 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer value = reader.nextInt();
        System.out.print(isPowerOfTwo(value));
    }


    public static boolean isPowerOfTwo(int value) {
        if(value==0){
            return false;
        }
        int abs = value < 0 ? -value : value;
        return Integer.highestOneBit(abs) == Integer.lowestOneBit(abs);
    }

}
