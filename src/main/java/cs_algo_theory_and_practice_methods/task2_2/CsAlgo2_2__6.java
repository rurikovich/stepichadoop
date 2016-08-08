package cs_algo_theory_and_practice_methods.task2_2;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_2__6 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int res = 1;

        int n = reader.nextInt();
        int[] fib = new int[n];
        if (n > 1) {
            fib[0] = 1;
            fib[1] = 1;
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            res=fib[n - 1];
        }


        System.out.println(res);

    }
}
