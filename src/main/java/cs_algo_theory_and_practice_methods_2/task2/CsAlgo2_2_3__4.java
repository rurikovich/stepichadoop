package cs_algo_theory_and_practice_methods_2.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_2_3__4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int e = reader.nextInt();
        int d = reader.nextInt();

        List<Operation> equals = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            equals.add(new Operation(reader.nextInt(), reader.nextInt()));
        }

        List<Operation> notEquals = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            notEquals.add(new Operation(reader.nextInt(), reader.nextInt()));
        }

        int equationsRes = processNumberSystem(n, equals, notEquals);
        System.out.println(equationsRes);
    }

    static int processNumberSystem(int n, List<Operation> equals, List<Operation> notEquals) {
        DigitSetSystem digitSetSystem = new DigitSetSystem(n);
        for (int i = 0; i < n; i++) {
            digitSetSystem.makeSet(i);
        }


        equals.forEach(operation -> {
            digitSetSystem.union(operation.a - 1, operation.b - 1);
        });

        for (Operation notEqual : notEquals) {
            int a_id = digitSetSystem.find(notEqual.a - 1);
            int b_id = digitSetSystem.find(notEqual.b - 1);
            if (a_id == b_id) {
                return 0;
            }
        }

        return 1;
    }


    static class DigitSetSystem {
        private int[] parent;
        private int[] range;

        public DigitSetSystem(int n) {
            this.parent = new int[n];
            this.range = new int[n];
        }

        public void makeSet(int x) {
            parent[x] = x;
        }

        public int find(int i) {
            while (i != parent[i]) {
                i = parent[i];
            }
            return i;
        }

        public void union(int x, int y) {
            int xId = find(x);
            int yId = find(y);
            if (xId == yId) {
                return;
            }

            if (range[xId] > range[yId]) {
                parent[yId] = xId;
            } else {
                parent[xId] = yId;
                if (range[xId] == range[yId]) {
                    range[yId] = range[yId] + 1;
                }
            }
        }


    }

    static class Operation {
        int a;
        int b;

        public Operation(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
