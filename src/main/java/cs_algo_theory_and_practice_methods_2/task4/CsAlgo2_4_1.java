package cs_algo_theory_and_practice_methods_2.task4;

import java.util.ArrayList;
import java.util.List;
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

        inOrderTreeSearchSystemOut(tree, 0);
        preOrderTreeSearchSystemOut(tree, 0);
        postOrderTreeSearchSystemOut(tree, 0);
    }

    static List<Integer> inOrderTreeSearch(ArrayList<TreeItem> tree, int top) {
        List<Integer> res = new ArrayList<>();
        TreeItem item = tree.get(top);
        if (item.left != -1) {
            List<Integer> leftKeys = inOrderTreeSearch(tree, item.left);
            res.addAll(leftKeys);
        }
        res.add(item.key);
        if (item.right != -1) {
            List<Integer> rightKeys = inOrderTreeSearch(tree, item.right);
            res.addAll(rightKeys);
        }
        return res;
    }

    static List<Integer> preOrderTreeSearch(ArrayList<TreeItem> tree, int top) {
        List<Integer> res = new ArrayList<>();
        TreeItem item = tree.get(top);

        res.add(item.key);

        if (item.left != -1) {
            List<Integer> leftKeys = preOrderTreeSearch(tree, item.left);
            res.addAll(leftKeys);
        }
        if (item.right != -1) {
            List<Integer> rightKeys = preOrderTreeSearch(tree, item.right);
            res.addAll(rightKeys);
        }
        return res;
    }

    static List<Integer> postOrderTreeSearch(ArrayList<TreeItem> tree, int top) {
        List<Integer> res = new ArrayList<>();
        TreeItem item = tree.get(top);
        if (item.left != -1) {
            List<Integer> leftKeys = postOrderTreeSearch(tree, item.left);
            res.addAll(leftKeys);
        }
        if (item.right != -1) {
            List<Integer> rightKeys = postOrderTreeSearch(tree, item.right);
            res.addAll(rightKeys);
        }
        res.add(item.key);
        return res;
    }

    static void inOrderTreeSearchSystemOut(ArrayList<TreeItem> tree, int top) {
        TreeItem item = tree.get(top);
        if (item.left != -1) {
            inOrderTreeSearchSystemOut(tree, item.left);
        }
        System.out.print(item.key + " ");
        if (item.right != -1) {
            inOrderTreeSearchSystemOut(tree, item.right);
        }
    }

    static void preOrderTreeSearchSystemOut(ArrayList<TreeItem> tree, int top) {
        TreeItem item = tree.get(top);
        System.out.print(item.key + " ");
        if (item.left != -1) {
            preOrderTreeSearchSystemOut(tree, item.left);
        }
        if (item.right != -1) {
            preOrderTreeSearchSystemOut(tree, item.right);
        }

    }

    static void postOrderTreeSearchSystemOut(ArrayList<TreeItem> tree, int top) {
        TreeItem item = tree.get(top);
        if (item.left != -1) {
            postOrderTreeSearchSystemOut(tree, item.left);
        }
        if (item.right != -1) {
            postOrderTreeSearchSystemOut(tree, item.right);
        }
        System.out.print(item.key + " ");
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
