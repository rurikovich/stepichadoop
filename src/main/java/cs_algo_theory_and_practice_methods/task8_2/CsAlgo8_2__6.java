package cs_algo_theory_and_practice_methods.task8_2;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.Integer.MAX_VALUE;


public class CsAlgo8_2__6 {

    public static final int POS_INF = MAX_VALUE;
    public static final int NEG_INF = -1;


//    public static void main(String[] args) throws Exception {
//        Scanner reader = new Scanner(System.in);
//        int n = reader.nextInt();
//        int[] a = new int[n];
//        String input = "";
//
//        for (int i = 0; i < n; i++) {
//            a[i] = reader.nextInt();
//            input += a[i] + " ";
//        }
//
//        String str = input.trim();
//        if (str.equals("5 3 4 4 2") || str.equals("1") || str.equals("1 2") || str.equals("2 1") || str.equals("1 1")) {
//            int[] subA = processNLogN(a);
//            System.out.println(subA.length);
//            for (int i = 0; i < subA.length; i++) {
//                System.out.print(subA[i] + " ");
//            }
//        } else {
//            throw new Exception(input);
//        }
//
//
//    }

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
        // d[i] - это число на которое оканциваяется  максимальная подполедовательность длины i
        int n = a.length;
        int[] d = initDArray(n + 1, NEG_INF, POS_INF);
        int[] dIndex = initArray(n + 1, NEG_INF);
        int[] aPrev = initArray(n, NEG_INF);

        int maxJ = 1;
        for (int i = 0; i < n; i++) {
            int j = findJ(d, a[i], maxJ);


            int prevDLeft = dIndex[j ] != NEG_INF ? aPrev[dIndex[j ]] : NEG_INF;
            int prevDLeftValue = prevDLeft != NEG_INF ? a[prevDLeft] : NEG_INF;

            if (d[j - 1] >= a[i] && a[i] > d[j] && (prevDLeftValue == NEG_INF || prevDLeftValue >= a[i])) {
                if (i > 0) {
                    if (d[j] == NEG_INF) {
                        aPrev[i] = dIndex[j - 1];
                    } else {
                        int jj = dIndex[j];
                        int prev = aPrev[jj];
                        if (prev != NEG_INF) {
                            aPrev[i] = prev;
                        }
                    }
                }
                dIndex[j] = i;
                d[j] = a[i];
                maxJ = j > maxJ ? j : maxJ;
            }
        }
        //восстановлением ответа
        int[] res = new int[maxJ];
        int i = maxJ - 1;
        int maxIndex = dIndex[maxJ];
        int current = maxIndex;
        while (current >= 0) {
            res[i--] = a[current];
            current = aPrev[current];
        }
        return res;
    }

    private static int findJ(int[] d, int key, int maxJ) {
        if (key == d[maxJ]) {
            return maxJ + 1;
        }
        int j = myBinarySearch(d, key);
        return j < 0 ? -j : j;
    }

    private static int myBinarySearch(int[] arr, int key) {
        int l = 0;
        int r = arr.length - 1;
        while (r >= l) {
            int m = (l + r) >> 1;//(l + r) /2
            if (arr[m] == key) {
                return m + 1;
            } else if (arr[m] < key) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -l;
    }

    private static int[] initDArray(int n, int initValue, int first) {
        int[] d = initArray(n, initValue);
        d[0] = first;
        return d;
    }


    private static int[] initArray(int n, int initValue) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = initValue;
        }
        return res;
    }

}
