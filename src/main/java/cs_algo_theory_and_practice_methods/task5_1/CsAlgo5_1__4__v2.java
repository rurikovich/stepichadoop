package cs_algo_theory_and_practice_methods.task5_1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo5_1__4__v2 {

    private void run() throws FileNotFoundException {
//        Scanner in = new Scanner(new File("input.txt"));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int k = in.nextInt();
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            b[i] = in.nextInt();
        }


        for (int i = 0; i < k; i++) {
            int pos = binarySearch(a, b[i]);
            System.out.print(pos + " ");
        }

    }

    private int binarySearch(int[] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (r >= l) {
            int m = (l + r) >> 1;
            if (a[m] == x) {
                return m+1;
            } else if (a[m] > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new CsAlgo5_1__4__v2().run();
    }
}
