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
                String str = strings[1];
                int index = h(str, m);
                if (table[index] == null) {
                    table[index] = new ArrayList<>();
                }
                if (!table[index].contains(str)) {
                    table[index].add(str);
                }

            }
            if (operation.equals("del")) {
                String str = strings[1];
                int index = h(str, m);
                if (table[index] != null && table[index].contains(str)) {
                    table[index].remove(str);
                }

            }
            if (operation.equals("find")) {
                String str = strings[1];
                int index = h(str, m);
                results.add((table[index] != null && table[index].contains(str)) ? "yes" : "no");
            }
            if (operation.equals("check")) {
                Integer i = Integer.valueOf(strings[1]);
                results.add(listToString(table[i]));
            }

        }


        return results;
    }

    static int h(String s, int m) {
        int p = 1_000_000_007;
        int x = 263;
        int res = 0;
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

    static String listToString(List list) {
        StringBuilder res = new StringBuilder("");

        for (int i = list.size() - 1; i >= 0; i--) {
            res.append(list.get(i)).append(" ");
        }
        if (res.length() != 0) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();

    }

}
