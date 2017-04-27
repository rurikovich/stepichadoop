package cs_algo_theory_and_practice_methods_2.task2;

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



}
