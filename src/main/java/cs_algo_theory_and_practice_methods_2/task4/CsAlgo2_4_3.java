package cs_algo_theory_and_practice_methods_2.task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class CsAlgo2_4_3 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        HashMap<Integer, Integer> keys = new HashMap<>();

        ArrayList<TreeItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int key = reader.nextInt();
            int left = reader.nextInt();
            int right = reader.nextInt();
            items.add(new TreeItem(key, left, right));
            addKey(keys, key);
        }
        SearchTree tree = new SearchTree(items);
        tree.setKeys(keys);

        Boolean isCorrect = checkTree(tree);
        System.out.println(isCorrect ? "CORRECT" : "INCORRECT");
    }

    private static void addKey(HashMap<Integer, Integer> keys, int key) {
        if (keys.containsKey(key)) {
            keys.put(key, keys.get(key) + 1);
        } else {
            keys.put(key, 1);
        }
    }


    static Boolean checkTree(SearchTree tree) {
        for (Integer key : tree.keys.keySet()) {
            int keyCount = tree.keys.get(key);
            if (tree.find(key, keyCount) == null) {
                return false;
            }
        }
        return true;
    }


    static class SearchTree {
        HashMap<Integer, Integer> keys;

        ArrayList<TreeItem> items = new ArrayList<>();

        public SearchTree(ArrayList<TreeItem> items) {
            this.items = items;
        }

        public void setKeys(HashMap<Integer, Integer> keys) {
            this.keys = keys;
        }

        public TreeItem find(int key, int count) {
            return findR(key, count, 0);
        }

        private TreeItem findR(int key, int count, int i) {
            TreeItem item = items.get(i);
            if (key == item.key) {
                count--;
                if (count > 0) {
                    return item.right != -1 ? findR(key, count, item.right) : null;
                } else {
                    return item;
                }
            } else if (item.left != -1 && key <= item.key) {
                return findR(key, count, item.left);
            } else if (item.right != -1 && key > item.key) {
                return findR(key, count, item.right);
            }
            return null;
        }
    }

    static class TreeItem {
        Integer key;
        Integer left;
        Integer right;

        public TreeItem(int key, int left, int right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

}