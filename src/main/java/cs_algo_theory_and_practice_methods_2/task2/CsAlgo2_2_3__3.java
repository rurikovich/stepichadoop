package cs_algo_theory_and_practice_methods_2.task2;

import java.util.*;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_2_3__3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();

        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            r.add(reader.nextInt());
        }

        List<TableUnion> tableUnions = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int destination = reader.nextInt();
            int source = reader.nextInt();
            tableUnions.add(new TableUnion(destination, source));
        }

        List<Integer> maxTableSizes = unionTables(n, m, r, tableUnions);
        maxTableSizes.forEach(System.out::println);
    }

    static List<Integer> unionTables(int n, int m, List<Integer> r, List<TableUnion> tableUnions) {
        List<Integer> maxTableSizes = new ArrayList<>();
        TableSetSystem tableSetSystem = new TableSetSystem(n, r);
        for (int i = 0; i < n; i++) {
            tableSetSystem.makeSet(i);
        }


        tableUnions.forEach(tu -> {
            tableSetSystem.union(tu.destination - 1, tu.source - 1);
            maxTableSizes.add(tableSetSystem.getMaxTableSize());
        });

        return maxTableSizes;
    }


    static class TableSetSystem {
        private int[] parent;
        private int[] range;
        private List<Integer> tableLines;
        private int maxTableSize;

        public TableSetSystem(int n, List<Integer> tableLines) {
            this.parent = new int[n];
            this.range = new int[n];
            this.tableLines = tableLines;
            maxTableSize = max(tableLines);
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
                updateTableLines(xId, yId);
            } else {
                parent[xId] = yId;
                updateTableLines(yId, xId);
                if (range[xId] == range[yId]) {
                    range[yId] = range[yId] + 1;
                }
            }
        }

        public Integer getMaxTableSize() {
            return maxTableSize;
        }

        private int max(List<Integer> columns) {
            int max = columns.get(0);
            for (Integer column : columns) {
                if (column > max) {
                    max = column;
                }
            }
            return max;
        }

        private void updateTableLines(int winnerId, int loserId) {
            int newtableLines = tableLines.get(winnerId) + tableLines.get(loserId);
            tableLines.set(winnerId, newtableLines);
            tableLines.set(loserId, 0);
            maxTableSize = Math.max(maxTableSize, newtableLines);
        }
    }

    static class TableUnion {
        int destination;
        int source;

        public TableUnion(int destination, int source) {
            this.destination = destination;
            this.source = source;
        }
    }

}
