package cs_algo_theory_and_practice_methods_2.task4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_4_2 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        ArrayList<TreeItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int key = reader.nextInt();
            int left = reader.nextInt();
            int right = reader.nextInt();
            items.add(new TreeItem(key, i == 0 ? -1 : null, left, right));
        }
        defineParents(items);
        SearchTree tree = new SearchTree(items);

        Boolean isCorrect = checkTree(tree);
        System.out.println(isCorrect);
    }

    static void defineParents(ArrayList<TreeItem> items) {
        for (int i = 0; i < items.size(); i++) {
            TreeItem item = items.get(i);
            if (item.left != -1) {
                TreeItem left = items.get(item.left);
                left.setParent(i);
            }
            if (item.right != -1) {
                TreeItem right = items.get(item.right);
                right.setParent(i);
            }
        }
    }

    static Boolean checkTree(SearchTree tree) {
        return null;
    }

    static class SearchTree {
        ArrayList<TreeItem> items = new ArrayList<>();

        public SearchTree(ArrayList<TreeItem> items) {
            this.items = items;
        }

        public TreeItem find(int key) {
            return find(key, 0);
        }

        public void insert(int key) {
            insert(key, 0);
        }

        public void delete(int key) {
            delete(key, 0);
        }

        private void delete(int key, int i) {
            TreeItem item = items.get(i);
            if (key == item.key) {
                if (item.isLeaf()) {
                    items.get(item.parent).left = -1;
                    items.set(i, null);
                }

//                if () {
//                }


            } else if (item.left != -1 && key <= item.key) {
                delete(key, item.left);
            } else if (item.right != -1 && key > item.key) {
                delete(key, item.right);
            }
        }

        private TreeItem find(int key, int i) {
            TreeItem item = items.get(i);
            if (key == item.key) {
                return item;
            } else if (item.left != -1 && key <= item.key) {
                return find(key, item.left);
            } else if (item.right != -1 && key > item.key) {
                return find(key, item.right);
            }
            return null;
        }

        private void insert(int key, int i) {
            TreeItem item = items.get(i);
            if (key <= item.key) {
                if (item.left != -1) {
                    find(key, item.left);
                } else {
                    items.add(new TreeItem(key, i, -1, -1));
                    item.left = items.size() - 1;
                }
            } else if (key > item.key) {
                if (item.right != -1) {
                    find(key, item.right);
                } else {
                    items.add(new TreeItem(key, i, -1, -1));
                    item.right = items.size() - 1;
                }
            }
        }


    }

    static class TreeItem {
        Integer key;
        Integer parent;
        Integer left;
        Integer right;

        public TreeItem(int key, int parent, int left, int right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public TreeItem(Integer key,  Integer left, Integer right) {
            this.key = key;
            this.parent = -1;
            this.left = left;
            this.right = right;
        }


        public void setParent(int parent) {
            this.parent = parent;
        }

        boolean isLeaf() {
            return left == -1 && right == -1;
        }

    }

}
