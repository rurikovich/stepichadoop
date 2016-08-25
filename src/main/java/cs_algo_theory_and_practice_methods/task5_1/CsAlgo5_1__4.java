package cs_algo_theory_and_practice_methods.task5_1;

import java.util.List;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo5_1__4 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] sortedArr = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArr[i] = reader.nextInt();
        }
        int k = reader.nextInt();
        int[] arrToTest = new int[k];
        for (int i = 0; i < k; i++) {
            arrToTest[i] = reader.nextInt();
        }
        int[] indexes = process(sortedArr, arrToTest);
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            sb.append(index).append(index != indexes.length - 1 ? " " : "");
        }
        System.out.print(sb.toString());
    }

    static int[] process(List<Integer> sortedArr, List<Integer> arrToTest) {
        return process(toIntArr(sortedArr), toIntArr(arrToTest));
    }

    static int[] toIntArr(List<Integer> integers) {
        int n = integers.size();
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }

    static int[] process(int[] sortedArr, int[] arrToTest) {
        int n = arrToTest.length;
        int[] indexes = new int[n];

        for (int i = 0; i < n; i++) {
            int number = arrToTest[i];
            int index = findIndex(sortedArr, number);
            indexes[i] = index;
        }
        return indexes;
    }

    private static int findIndex(int[] a, int x) {
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
}
