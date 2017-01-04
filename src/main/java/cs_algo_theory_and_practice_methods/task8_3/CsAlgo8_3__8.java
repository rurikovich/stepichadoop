package cs_algo_theory_and_practice_methods.task8_3;

import java.util.Scanner;

import static java.lang.Math.*;


public class CsAlgo8_3__8 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String str1 = reader.next();
        String str2 = reader.next();

        int k = process(str1, str2);
        System.out.print(k);

    }

    static int process(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int nCol = n + 1;
        int mCol = m + 1;

        int[] col1 = new int[nCol];
        int[] col2 = new int[nCol];

        for (int i = 0; i < nCol; i++) {
            col1[i] = i;
        }
//        printCol(col1);

        for (int j = 1; j < mCol; j++) {
            col2[0] = j;
            for (int i = 1; i < nCol; i++) {
                col2[i] = getMin(col2[i - 1] + 1, col1[i] + 1, col1[i - 1] + diff(str1.charAt(i-1), str2.charAt(j-1)));
            }
//            printCol(col2);
            col1 = col2;
            col2 = new int[nCol];
        }


        return col1[nCol - 1];
    }

    private static void printCol(int[] col) {
        for (int i = 0; i < col.length; i++) {
            System.out.print(col[i] + " ");
        }
        System.out.println();
    }

    private static int getMin(int a, int b, int c) {
        return min(a, min(b, c));
    }

    private static int diff(Character c1, Character c2) {
        return c1.equals(c2) ? 0 : 1;
    }

}
