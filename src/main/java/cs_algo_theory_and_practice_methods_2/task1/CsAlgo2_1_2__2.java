package cs_algo_theory_and_practice_methods_2.task1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_1_2__2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = reader.nextInt();
        }

        int treeHeight = processTree(n, tree);
        System.out.println(treeHeight);
    }

    static int processTree(int n, int[] tree) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        int head = -1;

        for (int i = 0; i < n; i++) {
            int parent = tree[i];
            if (parent != -1) {
                adjacencyList.get(parent).add(i);
            } else {
                head = i;
            }
        }


        return heightTree(head, adjacencyList);
    }

    private static int heightTree(int head, ArrayList<ArrayList<Integer>> adjacencyList) {
        int height = 1;
        for (Integer child : adjacencyList.get(head)) {
            height = Math.max(height, 1 + heightTree(child, adjacencyList));
        }
        return height;
    }


}
