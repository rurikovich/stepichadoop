package cs_algo_theory_and_practice_methods.task5_8;

import java.util.*;


public class CsAlgo5_8__3 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        HashMap<Integer, Integer> digits = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Integer d = reader.nextInt();
            int value = digits.containsKey(d) ? digits.get(d) + 1 : 1;
            digits.put(d, value);
        }

        ArrayList<Integer> keys = new ArrayList<>(digits.keySet());
        Collections.sort(keys);
        for (Integer k : keys) {
            for (int i = 0; i < digits.get(k); i++) {
                System.out.print(k + " ");
            }
        }
    }

}
