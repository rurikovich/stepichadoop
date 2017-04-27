package cs_algo_theory_and_practice_methods_2.task2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by User on 26.04.2017.
 */
public class MinHeap {
    private final int maxHeapsize;
    private int size;
    private Integer[] arr;

    ArrayList<Swap> swaps = new ArrayList<>();

    public MinHeap() {
        maxHeapsize = 100;
        arr = new Integer[maxHeapsize];
    }

    public MinHeap(int n) {
        maxHeapsize = n;
        this.arr = new Integer[n];
    }

    public int getMin() {
        int res = arr[0];
        swap(arr, 0, size - 1);
        size--;
        pushDown(arr, 0);
        return res;
    }

    public void insert(int value) {
        int last = this.size;
        arr[last] = value;
        pushUp(arr, last);
        this.size++;
    }

    public Integer[] getArr() {
        return Arrays.copyOfRange(arr, 0, size);
    }

    public void setSize(int size) {
        this.size = size;
    }

    void pushUp(Integer[] arr, int i) {
        int parent = getParent(i);
        if (parent >= 0 && arr[parent] > arr[i]) {
            swap(arr, i, parent);
            pushUp(arr, parent);
        }
    }

    private void swap(Integer[] arr, Integer i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public Integer[] buildHeap(Integer[] arr) {
        size = arr.length;
        swaps.clear();
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            pushDown(arr, i);
        }
        return arr;
    }

    void pushDown(Integer[] arr, int i) {
        int leftChild = getLeft(i);
        int rightChild = getRight(i);

        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(i);
        if (leftChild < size) {
            indexes.add(leftChild);
        }
        if (rightChild < size) {
            indexes.add(rightChild);
        }
        int swapIndex = findMinIndex(arr, indexes);
        if (swapIndex == i) {
            return;
        }

        swaps.add(new Swap(i, swapIndex));

        swap(arr, i, swapIndex);
        pushDown(arr, swapIndex);
    }

    private int getParent(int i) {
        return i == 0 ? -1 : (i - 1) / 2;
    }

    private int getLeft(int i) {
        return 2 * i + 1;
    }

    private int getRight(int i) {
        return 2 * i + 2;
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


    static class Swap {
        public int i;
        public int j;

        public Swap(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "{" +
                    +i +
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
