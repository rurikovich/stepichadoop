package cs_algo_theory_and_practice_methods_2.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_3_1_direct_table {

    public static final String NOT_FOUND = "not found";

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        String[] commands = new String[n];
        reader.nextLine();
        for (int i = 0; i < n; i++) {
            commands[i] = reader.nextLine();
        }
        List<String> results = processRequests(commands);
        results.forEach(System.out::println);
    }

    static List<String> processRequests(String[] commands) {
        List<String> results = new ArrayList<>();

        int maxLength = 10_000_000;
        String[] table = new String[maxLength];

        for (String command : commands) {
            String[] strings = command.split(" ");
            String operation = strings[0];
            int number = Integer.parseInt(strings[1]);
            if (operation.equals("add")) {
                table[number] = strings[2];
            }
            if (operation.equals("del")) {
                table[number] = null;
            }
            if (operation.equals("find")) {
                String name = table[number];
                results.add(name != null ? name : NOT_FOUND);
            }
        }
        return results;
    }


}
