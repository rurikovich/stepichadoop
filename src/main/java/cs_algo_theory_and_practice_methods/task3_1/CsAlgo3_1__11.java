package cs_algo_theory_and_practice_methods.task3_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo3_1__11 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        ArrayList<Integer> res = process(n);

        System.out.println(res.size());
        res.forEach(System.out::println);
    }

    public static ArrayList<Integer> process(int n) {
        int nn = n;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (shouldAdd(nn, numbers, i)) {
                numbers.add(i);
                nn -= i;
                if (nn <= 0) {
                    break;
                }
            }
        }
        return numbers;
    }

    private static boolean shouldAdd(int nn, ArrayList<Integer> numbers, int i) {
        return !numbers.contains(nn - i)  && i != nn - i;
    }

}
