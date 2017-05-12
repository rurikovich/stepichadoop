package cs_algo_theory_and_practice_methods_2.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

class CsAlgo2_4_3 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        ArrayList<TreeItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int key = reader.nextInt();
            int left = reader.nextInt();
            int right = reader.nextInt();
            items.add(new TreeItem(key, left, right));
        }
        SearchTree tree = new SearchTree(items);

        Boolean isCorrect = checkTree(tree);
        System.out.println(isCorrect ? "CORRECT" : "INCORRECT");
    }

    static Boolean checkTree(SearchTree tree) {
        List<Integer> keys = tree.items.stream().map(t -> t.key).collect(toList());
        for (int key : keys) {
            if (tree.find(key) == null) {
                return false;
            }
        }
        return true;
    }

    static class SearchTree {
        ArrayList<TreeItem> items = new ArrayList<>();

        public SearchTree(ArrayList<TreeItem> items) {
            this.items = items;
        }

        public TreeItem find(int key) {
            return find(key, 0);
        }

        private TreeItem find(int key, int i) {
            TreeItem item = items.get(i);
            if (key == item.key) {
                return item;
            } else if (item.left != -1 && key < item.key) {
                return find(key, item.left);
            } else if (item.left != -1 && key == item.key) {
                return null;
            }
            else if (item.right != -1 && key > item.key) {
                return find(key, item.right);
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