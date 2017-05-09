package cs_algo_theory_and_practice_methods_2.task4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_4_1 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        ArrayList<TreeItem> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int key = reader.nextInt();
            int left = reader.nextInt();
            int right = reader.nextInt();
            tree.add(new TreeItem(key, left, right));
        }

         inOrderTreeSearch(tree, 0);
         preOrderTreeSearch(tree, 0);
         postOrderTreeSearch(tree, 0);


    }

    static void inOrderTreeSearch(ArrayList<TreeItem> tree, int top) {
        TreeItem item = tree.get(top);
        if (item.left != -1) {
            inOrderTreeSearch(tree, item.left);
        }
        System.out.print(item.key+" ");
        if (item.right != -1) {
             inOrderTreeSearch(tree, item.right);
        }
    }

    static void preOrderTreeSearch(ArrayList<TreeItem> tree, int top) {
        TreeItem item = tree.get(top);
        System.out.print(item.key+" ");
        if (item.left != -1) {
            preOrderTreeSearch(tree, item.left);
        }
        if (item.right != -1) {
            preOrderTreeSearch(tree, item.right);
        }

    }

    static void postOrderTreeSearch(ArrayList<TreeItem> tree, int top) {
        TreeItem item = tree.get(top);
        if (item.left != -1) {
             postOrderTreeSearch(tree, item.left);
        }
        if (item.right != -1) {
             postOrderTreeSearch(tree, item.right);
        }
        System.out.print(item.key+" ");
    }


    static class TreeItem {
        int key;
        int left;
        int right;

        public TreeItem(int key, int left, int right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

}
