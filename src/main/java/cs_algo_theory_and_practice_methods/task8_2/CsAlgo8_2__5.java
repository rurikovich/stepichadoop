package cs_algo_theory_and_practice_methods.task8_2;

import java.util.Scanner;


public class CsAlgo8_2__5 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = reader.nextInt();
        }

        int k = process(a);
        System.out.print(k);

    }

    static int process(int[] a) {
        int length = a.length;
        int[] d = new int[length];
        for (int i = 0; i < length; i++) {
            d[i] = 1;
        }

        for (int i = 0; i < length; i++) {
            int maxD = -1;
            for (int j = 0; j < i; j++) {
                if (a[j] <= a[i] && a[i] % a[j] == 0 && d[j] > maxD) {
                    maxD = d[j];
                }
            }
            if (maxD > 0) {
                d[i] = maxD + 1;
            }
        }

        int max = d[0];
        for (int i = 0; i < length; i++) {
            if (d[i] > max) {
                max = d[i];
            }
        }

        return max;
    }

}
