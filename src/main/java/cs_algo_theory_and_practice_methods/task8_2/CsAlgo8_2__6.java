package cs_algo_theory_and_practice_methods.task8_2;

import java.util.Scanner;
import java.util.Stack;


public class CsAlgo8_2__6 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = reader.nextInt();
        }

        int[] subA = processNLogN(a);
        System.out.println(subA.length);
        for (int i = 0; i < subA.length; i++) {
            System.out.print(subA[i] + " ");
        }
    }

    static int[] process(int[] a) {
        int length = a.length;
        int[] d = new int[length];
        for (int i = 0; i < length; i++) {
            d[i] = 1;
        }

        for (int i = 0; i < length; i++) {
            int maxD = -1;
            for (int j = 0; j < i; j++) {
                if (a[j] >= a[i] && d[j] > maxD) {
                    maxD = d[j];
                }
            }
            if (maxD > 0) {
                d[i] = maxD + 1;
            }
        }

        int max = d[0];
        int maxI = 0;
        for (int i = 0; i < length; i++) {
            if (d[i] > max) {
                max = d[i];
                maxI = i;
            }
        }

        Stack<Integer> stack = new Stack<>();
        int current = maxI;
        while (current > 0) {
            stack.push(current);
            for (int i = current - 1; i >= 0; i--) {
                if (d[i] == d[current] - 1) {
                    current = i;
                    break;
                }
            }
        }
        stack.push(current);

        int[] subA = new int[stack.size()];
        int i = 0;
        while (stack.size() > 0) {
            subA[i++] = stack.pop() + 1;
        }


        return subA;
    }


    static int[] processNLogN(int[] a) {
        int n = a.length;
        // d[i] - это число на которое оканциваяется  максимальная подполедовательность длины i
        int[] d = new int[n + 1];
        int[] dIndex = new int[n + 1];
        int[] aPrevIndex = new int[n];

        d[0] = -1;
        for (int i = 1; i <= n; i++) {
            d[i] = Integer.MAX_VALUE;
        }

        int maxJ = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (d[j - 1] < a[i] && a[i] < d[j]) {
                    dIndex[j] = i;
//                    aPrevIndex[]
                    d[j] = a[i];

                    if (j > maxJ) {
                        maxJ = j;
                    }
                }
            }
        }

        // восстановлением ответа
//        for (int i = 0; i <; i++) {
//
//        }


        return new int[]{};
    }

}
