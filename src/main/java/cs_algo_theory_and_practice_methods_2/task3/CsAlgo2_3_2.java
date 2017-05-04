package cs_algo_theory_and_practice_methods_2.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_3_2 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int m = reader.nextInt();
        int n = reader.nextInt();

        String[] commands = new String[n];
        for (int i = 0; i < n; i++) {
            commands[i] = reader.nextLine();
        }
        List<String> results = processRequests(m, commands);

        results.forEach(System.out::println);
    }

    static List<String> processRequests(int m, String[] commands) {
        List<String> results = new ArrayList<>();
        ArrayList<String>[] table = new ArrayList[m];

        for (String command : commands) {
            String[] strings = command.split(" ");
            String operation = strings[0];

            if (operation.equals("add")) {
                String str = strings[0];
            }
            if (operation.equals("del")) {
                String str = strings[0];
            }
            if (operation.equals("find")) {
                String str = strings[0];
            }
            if (operation.equals("check")) {
                Integer i = Integer.valueOf(strings[0]);
            }

        }


        return results;
    }

    static long h(String s, int m) {
        int p = 1_000_000_007;
        int x = 263;

        long res = 0;


        int x_mod_p = x % p;
        for (int i = 0; i < s.length(); i++) {
            int charCode = (int) s.charAt(i);

            long pow_mod_p = charCode % p;
            for (int j = 0; j < i; j++) {
                pow_mod_p = (pow_mod_p * x_mod_p) % p;
            }
            res += pow_mod_p;
        }
        res = (res % p) % m;
        return res;
    }


}
