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

        public SplayTreeItem find(int key, int index) {
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

        private void splay(SplayTreeItem item) {

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
