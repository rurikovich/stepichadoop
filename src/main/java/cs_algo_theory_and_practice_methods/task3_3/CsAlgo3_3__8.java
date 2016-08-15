package cs_algo_theory_and_practice_methods.task3_3;

import java.util.*;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo3_3__8 {

    public static final String INSERT = "Insert";
    public static final String EXTRACT_MAX = "ExtractMax";

    public static void main(String[] args) {
        List<String> commands = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        for (int i = 0; i <= n; i++) {
            commands.add(reader.nextLine());
        }
        List<Integer> res = process(commands);
        res.stream().forEach(System.out::println);
    }

    static List<Integer> process(List<String> commands) {
        MyPriorityQuery priorityQuery = new MyPriorityQuery();

        ArrayList<Integer> output = new ArrayList<>();
        for (String c : commands) {
            if (c.startsWith(INSERT)) {
                int value = Integer.parseInt(c.split(" ")[1]);
                priorityQuery.insert(value);
            }
            if (c.startsWith(EXTRACT_MAX)) {
                int value = priorityQuery.extractMax();
                output.add(value);
            }
        }
        return output;
    }


    static class MyPriorityQuery {
        private ArrayList<Integer> arr = new ArrayList<>();

        public void insert(Integer x) {
            arr.add(x);
            siftUpSiftUp(getLastIndex());
        }

        public Integer extractMax() {
            if (!arr.isEmpty()) {
                Integer max = arr.get(0);
                arr.set(0, getLast());
                removeLast();
                siftDownSiftDown(0);
                return max;
            }
            return null;
        }

        private void siftUpSiftUp(int index) {
            int i = index;
            while (arr.get(i / 2) < arr.get(i)) {
                switchPlaces(i, i / 2);
                i = i / 2;
            }
        }

        private void siftDownSiftDown(int index) {
            int i = index;
            while (parentLargerThenChilds(i)) {
                int leftChildIndex = 2 * i;
                int rightChildIndex = 2 * i + 1;

                int maxIndex = -1;
                if (isIndexInArr(leftChildIndex)) {
                    maxIndex = leftChildIndex;
                }

                if (isIndexInArr(rightChildIndex)) {
                    if (arr.get(rightChildIndex) > arr.get(leftChildIndex)) {
                        maxIndex = rightChildIndex;
                    }
                }

                if (maxIndex >= 0) {
                    switchPlaces(i, maxIndex);
                    i = maxIndex;
                }

            }
        }

        private boolean isIndexInArr(int leftChildIndex) {
            return leftChildIndex < arr.size();
        }

        private boolean parentLargerThenChilds(int i) {
            int leftChildIndex = 2 * i;
            int rightChildIndex = 2 * i + 1;
            return (isIndexInArr(leftChildIndex) && arr.get(i) < arr.get(leftChildIndex)) || (isIndexInArr(rightChildIndex) && arr.get(i) < arr.get(rightChildIndex));
        }

        private void switchPlaces(int index, int parentIndex) {
            int a = arr.get(index);
            arr.set(index, arr.get(parentIndex));
            arr.set(parentIndex, a);
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
