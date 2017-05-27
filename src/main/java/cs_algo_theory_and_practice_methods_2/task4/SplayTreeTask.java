package cs_algo_theory_and_practice_methods_2.task4;

import java.util.ArrayList;
import java.util.List;

import static cs_algo_theory_and_practice_methods_2.task4.SplayTreeTask.ChildType.LEFT;
import static cs_algo_theory_and_practice_methods_2.task4.SplayTreeTask.ChildType.NOT_A_CHILD;
import static cs_algo_theory_and_practice_methods_2.task4.SplayTreeTask.ChildType.RIGHT;

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
            if (items.isEmpty()) {
                SplayTreeItem treeItem = new SplayTreeItem(key, -1, -1, -1, 0, NOT_A_CHILD);
                items.add(treeItem);
            }

            SplayTreeItem item = items.get(index);
            if (key == item.key) {
                return item;
            } else if (key < item.key) {
                if (item.left != -1) {
                    return insert(key, item.left);
                } else {
                    SplayTreeItem treeItem = new SplayTreeItem(key, item.index, -1, -1, items.size(), LEFT);
                    item.left = items.size();
                    items.add(treeItem);
                    return treeItem;
                }
            } else if (key > item.key) {
                if (item.right != -1) {
                    return insert(key, item.right);
                } else {
                    SplayTreeItem treeItem = new SplayTreeItem(key, item.index, -1, -1, items.size(), RIGHT);
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

                if (item.isLeftChild() && parent.isLeftChild()) {
                    ziqziq(item, parent, grandFather);
                } else if (item.isLeftChild() && parent.isRightChild()) {
                    ziqzaq(item, parent, grandFather);
                } else if (item.isRightChild() && parent.isRightChild()) {
                    zaqzaq(item, parent, grandFather);
                } else if (item.isRightChild() && parent.isLeftChild()) {
                    zaqziq(item, parent, grandFather);
                }
            } else {
                if (item.isLeftChild()) {
                    ziq(item, parent);
                } else if (item.isRightChild()) {
                    zaq(item, parent);
                }


            }

        }

        private void ziqziq(SplayTreeItem splayTreeItem, SplayTreeItem parent, SplayTreeItem item) {

        }

        private void ziqzaq(SplayTreeItem splayTreeItem, SplayTreeItem parent, SplayTreeItem item) {

        }

        private void zaqzaq(SplayTreeItem item, SplayTreeItem parent, SplayTreeItem grandFather) {

        }

        private void zaqziq(SplayTreeItem item, SplayTreeItem parent, SplayTreeItem grandFather) {

        }


        private void ziq(SplayTreeItem item, SplayTreeItem parent) {

        }

        private void zaq(SplayTreeItem item, SplayTreeItem parent) {

        }


    }


    static class SplayTreeItem {
        int key;
        int parent;
        int left;
        int right;
        int index;
        ChildType childType;

        public SplayTreeItem(int key, int parent, int left, int right, int index, ChildType childType) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.index = index;
            this.childType = childType;
        }

        public boolean isLeftChild() {
            return childType.equals(LEFT);
        }


        public boolean isRightChild() {
            return childType.equals(RIGHT);
        }

    }

    enum ChildType {
        LEFT,
        RIGHT,
        NOT_A_CHILD
    }


}
