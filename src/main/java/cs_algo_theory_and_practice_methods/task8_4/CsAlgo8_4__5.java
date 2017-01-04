package cs_algo_theory_and_practice_methods.task8_4;

import java.util.Scanner;

import static java.lang.Math.*;


public class CsAlgo8_4__5 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int weight = reader.nextInt();
        int n = reader.nextInt();

        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = reader.nextInt();
        }

        int k = process(weight, w);
        System.out.print(k);

    }

    static int process(int W, int[] w) {
        int n = w.length;
        int[][] K = new int[W + 1][n + 1];

        for (int j = 1; j <= n; j++) {
            for (int ww = 1; ww <= W; ww++) {
                K[ww][j] = K[ww][j - 1];
                int weight = w[j - 1];
                if (weight <= ww) {
                    K[ww][j] = max(K[ww][j], K[ww - weight][j - 1] + weight);
                }
            }
        }

        return K[W][n];
    }


}
