package cs_algo_theory_and_practice_methods.task8_2;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.Integer.*;


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
        d[0] = -1;
        for (int i = 1; i <= n; i++) {
            d[i] = MAX_VALUE;
        }

        int[] dIndex = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dIndex[i] = -1;
        }

        int[] aPrevIndex = new int[n];
        for (int i = 0; i < n; i++) {
            aPrevIndex[i] = -1;
        }


        int maxJ = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (d[j - 1] < a[i] && a[i] < d[j]) {
                    if (i > 0) {
                        if (d[j] == MAX_VALUE) {
                            aPrevIndex[i] = dIndex[j - 1];
                        } else {
                            int jj = dIndex[j];
                            aPrevIndex[i] = aPrevIndex[jj];
                        }
                    }
                    dIndex[j] = i;
                    d[j] = a[i];

                    if (j > maxJ) {
                        maxJ = j;
                    }
                }
            }
        }

        //восстановлением ответа
        int[] res = new int[maxJ];

        int i = maxJ - 1;
        int maxIndex = dIndex[maxJ];
        int current = maxIndex;
        while (current >= 0) {
            res[i--] = current + 1;
            current = aPrevIndex[current];

        }

        return res;
    }

}
