package cs_algo_theory_and_practice_methods.task3_3;

import java.util.*;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo3_3__8 {

    public static void main(String[] args) {
        List<String> commands = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        for (int i = 0; i < n; i++) {
            commands.add(reader.nextLine());
        }
        List<Integer> res = process(commands);
        res.stream().forEach(System.out::println);
    }

    static List<Integer> process(List<String> commands) {
        return null;
    }


    static class MyPriorityQuery {
        private ArrayList<Integer> arr = new ArrayList<>();

        public void insert(Integer x) {
            arr.add(x);
            siftUpSiftUp(getLastIndex());
        }

        public Integer extractMax() {
            if (arr.isEmpty()) {
                return null;
            }
            Integer max = arr.get(0);
            arr.set(0, getLast());
            removeLast();
            siftDownSiftDown(0);
            return max;
        }

        private void siftUpSiftUp(int index) {
            int i = index;
            while (arr.get(i / 2) < arr.get(i)) {
                switchPlaces(i, i / 2);
                i = i / 2;
            }
        }

        private void switchPlaces(int index, int parentIndex) {
            int a = arr.get(index);
            arr.set(index, arr.get(parentIndex));
            arr.set(parentIndex, a);
        }

        private void siftDownSiftDown(int index) {
        }

        private void removeLast() {
            arr.remove(arr.size() - 1);
        }

        private Integer getLast() {
            return arr.get(arr.size() - 1);
        }

        private int getLastIndex() {
            return arr.size() - 1;
        }

    }


}
