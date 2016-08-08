package cs_algo_theory_and_practice_methods.task2_2;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_2__7 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int res = 1;

        int n = reader.nextInt();
        int[] fibEnd = new int[n];
        if (n > 1) {
            fibEnd[0] = 1;
            fibEnd[1] = 1;
            for (int i = 2; i < n; i++) {
                fibEnd[i] = (fibEnd[i - 1] + fibEnd[i - 2])%10;
            }
            res=fibEnd[n - 1];
        }


        System.out.println(res);

    }
}
