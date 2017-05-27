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
            while (item.parent != -1) {
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
        }

        private void ziqziq(SplayTreeItem item, SplayTreeItem parent, SplayTreeItem grandFather) {
            int grandFatherParentIndex = grandFather.parent;
            ChildType grandFatherChildType = grandFather.childType;

            updateLeftChild(grandFather, parent.right);
            grandFather.parent = parent.index;

            updateRightChild(parent, grandFather.index);
            parent.parent = item.index;

            updateRightChild(item, parent.index);
            item.childType = grandFatherChildType;
            item.parent = grandFatherParentIndex;
        }


        private void ziqzaq(SplayTreeItem item, SplayTreeItem parent, SplayTreeItem grandFather) {
            int grandFatherParentIndex = grandFather.parent;
            ChildType grandFatherChildType = grandFather.childType;

            updateRightChild(grandFather, item.left);
            grandFather.parent = item.index;

            updateLeftChild(parent, item.right);
            parent.parent = item.index;

            updateRightChild(item, parent.index);
            updateLeftChild(item, grandFather.index);
            item.parent = grandFatherParentIndex;
            item.childType = grandFatherChildType;
        }

        private void zaqzaq(SplayTreeItem item, SplayTreeItem parent, SplayTreeItem grandFather) {
            int grandFatherParentIndex = grandFather.parent;
            ChildType grandFatherChildType = grandFather.childType;

            updateRightChild(grandFather, parent.left);
            grandFather.parent = parent.index;

            updateRightChild(parent, item.left);
            updateLeftChild(parent, grandFather.index);
            parent.parent = item.index;

            updateLeftChild(item, parent.index);
            item.parent = grandFatherParentIndex;
            item.childType = grandFatherChildType;
        }

        private void zaqziq(SplayTreeItem item, SplayTreeItem parent, SplayTreeItem grandFather) {
            int grandFatherParentIndex = grandFather.parent;
            ChildType grandFatherChildType = grandFather.childType;

            updateLeftChild(grandFather, item.right);
            grandFather.parent = item.index;

            updateRightChild(parent, item.left);
            parent.parent = item.index;

            updateRightChild(item, grandFather.index);
            updateLeftChild(item, parent.index);
            item.parent = grandFatherParentIndex;
            item.childType = grandFatherChildType;

        }


        private void ziq(SplayTreeItem item, SplayTreeItem parent) {
            int parentParentIndex = parent.parent;
            ChildType parentChildType = parent.childType;

            updateLeftChild(parent, item.right);
            parent.parent = item.index;

            updateRightChild(item, parent.index);
            item.parent = parentParentIndex;
            item.childType = parentChildType;
        }

        private void zaq(SplayTreeItem item, SplayTreeItem parent) {
            int parentParentIndex = parent.parent;
            ChildType parentChildType = parent.childType;

            updateRightChild(parent, item.left);
            parent.parent = item.index;

            updateLeftChild(item, parent.index);
            item.parent = parentParentIndex;
            item.childType = parentChildType;
        }


        private void updateLeftChild(SplayTreeItem itemToUpdate, int newLeftChildIndex) {
            itemToUpdate.left = newLeftChildIndex;
            if (newLeftChildIndex != -1) {
                SplayTreeItem item = items.get(newLeftChildIndex);
                item.childType = LEFT;
                item.parent = itemToUpdate.index;
            }
        }


        private void updateRightChild(SplayTreeItem itemToUpdate, int newRightChildIndex) {
            itemToUpdate.right = newRightChildIndex;
            if (newRightChildIndex != -1) {
                SplayTreeItem item = items.get(newRightChildIndex);
                item.childType = RIGHT;
                item.parent = itemToUpdate.index;
            }
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
