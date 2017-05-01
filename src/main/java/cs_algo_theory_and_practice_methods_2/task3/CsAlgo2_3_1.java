package cs_algo_theory_and_practice_methods_2.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_3_1 {

    public static final String NOT_FOUND = "not found";

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        String[] commands = new String[n];
        reader.nextLine();
        for (int i = 0; i < n; i++) {
            commands[i] = reader.nextLine();
        }

        OpenAddressTable table = new OpenAddressTable();
        List<String> results = new ArrayList<>();
        for (String command : commands) {
            String[] strings = command.split(" ");
            String operation = strings[0];
            int number = Integer.parseInt(strings[1]);
            if (operation.equals("add")) {
                table.add(number, strings[2]);
            }
            if (operation.equals("del")) {
                table.del(number);
            }
            if (operation.equals("find")) {
                results.add(table.find(number));
            }
        }

        results.forEach(System.out::println);
    }


    static class OpenAddressTable {
        Data deleted = new Data(Integer.MAX_VALUE, "deleted");

        public static final int M = 100_000;
        Data[] table;

        public OpenAddressTable() {
            table = new Data[M];
        }

        public void add(int number, String name) {
            for (int j = 0; j < M; j++) {
                int index = h(number, j);
                if (table[index] == null || table[index] == deleted) {
                    table[index] = new Data(number, name);
                    return;
                } else if (table[index].number == number) {
                    table[index].name = name;
                }
            }
        }

        public void del(int number) {
            for (int j = 0; j < M; j++) {
                int index = h(number, j);
                Data data = table[index];
                if (data != null && data.number == number) {
                    table[index] = deleted;
                    return;
                }
            }
        }

        public String find(int number) {
            for (int j = 0; j < M; j++) {
                int index = h(number, j);
                if (table[index] == null) {
                    return NOT_FOUND;
                } else if (table[index].number == number) {
                    return table[index].name;
                }
            }
            return NOT_FOUND;
        }

        private int h(int k, int j) {
            return (h0(k) + j) % M;
        }

        private int h0(int k) {
            return k % M;
        }


    }

    static class Data {
        int number;
        String name;

        public Data(int number, String name) {
            this.number = number;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data data = (Data) o;

            if (number != data.number) return false;
            return name != null ? name.equals(data.name) : data.name == null;

        }

        @Override
        public int hashCode() {
            int result = number;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }


}
