package cs_algo_theory_and_practice_methods.task2_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_2__8 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        long n = reader.nextLong();
        int m = reader.nextInt();
        System.out.println(process(n, m));
    }

    public static Integer process(long n, int m) {
        ArrayList<Integer> p = new ArrayList<>();
        p.add(1);
        p.add(1);
        for (int i = 2; i < n; i++) {
            p.add((p.get(i - 1) + p.get(i - 2)) % m);
            if (p.get(i - 1) == 1 && p.get(i) == 1) {
                p.remove(p.size() - 1);
                p.remove(p.size() - 1);
                break;
            }
        }

        int pizanoLength = p.size();
        int index = (int) (n % pizanoLength);
        return p.get(index > 0 ? index - 1 : pizanoLength - 1);
    }


}
