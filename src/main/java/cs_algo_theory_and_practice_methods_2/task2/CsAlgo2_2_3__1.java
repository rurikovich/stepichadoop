package cs_algo_theory_and_practice_methods_2.task2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_2_3__1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }

        MinHeap minHeap = new MinHeap(n);
        minHeap.buildHeap(arr);


        System.out.println(minHeap.swaps.size());
        minHeap.swaps.forEach(swap -> System.out.println(swap.i + " " + swap.j));
    }


    static class MinHeap {
        private int maxHeapsize;
        private int size;
        private Integer[] arr;

        ArrayList<Swap> swaps = new ArrayList<>();

        public MinHeap() {
        }

        public MinHeap(int n) {
            maxHeapsize = n;
            this.arr = new Integer[n];
        }


        public Integer[] buildHeap(Integer[] arr) {
            swaps.clear();
            for (int i = arr.length / 2 - 1; i >= 0; i--) {
                pushDown(arr, i);
            }
            return arr;
        }

        void pushDown(Integer[] arr, int i) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            ArrayList<Integer> indexes = new ArrayList<>();
            indexes.add(i);
            if (leftChild < arr.length) {
                indexes.add(leftChild);
            }
            if (rightChild < arr.length) {
                indexes.add(rightChild);
            }
            int swapIndex = findMinIndex(arr, indexes);
            if (swapIndex == i) {
                return;
            }

            swaps.add(new Swap(i, swapIndex));

            int temp = arr[i];
            arr[i] = arr[swapIndex];
            arr[swapIndex] = temp;
            pushDown(arr, swapIndex);
        }

        private int findMinIndex(Integer[] arr, ArrayList<Integer> indexes) {
            int min = indexes.get(0);
            for (int index : indexes) {
                if (arr[min] > arr[index]) {
                    min = index;
                }
            }
            return min;
        }


    }

    static class Swap {
        int i;
        int j;

        public Swap(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "{" +
                    + i +
                    ", " + j +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Swap swap = (Swap) o;

            if (i != swap.i) return false;
            return j == swap.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }


}
