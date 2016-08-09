package cs_algo_theory_and_practice_methods.task2_3;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_3__5 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int a = reader.nextInt();
        int b = reader.nextInt();
        System.out.println(process(a, b));
    }

    public static int process(int a, int b) {
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        } else if (a >= b) {
            return process(a % b, b);
        } else if (b >= a) {
            return process(a, b % a);
        } else {
            return 1;
        }
    }


}
