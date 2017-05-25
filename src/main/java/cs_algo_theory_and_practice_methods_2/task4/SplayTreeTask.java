package cs_algo_theory_and_practice_methods_2.task4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rurik on 25/05/17.
 */
public class SplayTreeTask {

    static class SplayTree {

        List<SplayTreeItem> items = new ArrayList<>();

        public SplayTreeItem find(int key) {
            SplayTreeItem item = find(key, 0);
            splay(item);
            return item;
        }

        public void insert(int key) {
            SplayTreeItem item = insert(key, 0);
            splay(item);
        }

        SplayTreeItem find(int key, int index) {
            SplayTreeItem item = items.get(index);
            if (key == item.key) {
                return item;
            } else if (key < item.key) {
                if (item.left != -1) {
                    return find(key, item.left);
                } else {
                    return null;
                }
            } else if (key > item.key) {
                if (item.right != -1) {
                    return find(key, item.right);
                } else {
                    return null;
                }
            }
            return null;
        }

        SplayTreeItem insert(int key, int index) {
            SplayTreeItem item = items.get(index);
            if (key == item.key) {
                return item;
            } else if (key < item.key) {
                if (item.left != -1) {
                    return insert(key, item.left);
                } else {
                    SplayTreeItem treeItem = new SplayTreeItem(key, item.index, -1, -1, items.size());
                    item.left = items.size();
                    items.add(treeItem);
                    return treeItem;
                }
            } else if (key > item.key) {
                if (item.right != -1) {
                    return insert(key, item.right);
                } else {
                    SplayTreeItem treeItem = new SplayTreeItem(key, item.index, -1, -1, items.size());
                    item.right = items.size();
                    items.add(treeItem);
                    return treeItem;
                }
            }
            return null;

        }


        private void splay(SplayTreeItem item) {
            if (item.parent == -1) {
                return;
            }

            SplayTreeItem parent = items.get(item.parent);
            if (parent.parent != -1) {
                SplayTreeItem grandFather = items.get(parent.parent);



            } else {

            }

        }

        private void ziqziq(SplayTreeItem item){

        }

        private void ziqzaq(SplayTreeItem item){

        }


    }


    static class SplayTreeItem {
        int key;
        int parent;
        int left;
        int right;
        int index;

        public SplayTreeItem(int key, int parent, int left, int right, int index) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.index = index;
        }
    }


}
