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
    List<SplayTreeItem> treeItems = new ArrayList<>();

    static class SplayTree {
        int treeHeadIndex;

        List<SplayTreeItem> items;

        public SplayTree() {
            treeHeadIndex = 0;
            items = new ArrayList<>();
        }

        public SplayTree(int treeHeadIndex, List<SplayTreeItem> items) {
            this.treeHeadIndex = treeHeadIndex;
            this.items = items;
        }

        public SplayTreeItem getHead() {
            return items.get(treeHeadIndex);
        }

        public SplayTreeItem find(int key) {
            return find(key, treeHeadIndex);
        }

        public void insert(int key) {
            insert(key, treeHeadIndex);

        }

        public SplayTreeItem getMax() {
            SplayTreeItem item = getHead();
            while (item.right != -1) {
                item = items.get(item.right);
            }
            return item;
        }

        public void splay(SplayTreeItem item) {
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

                    updateItemSum(parent);
                    updateItemSum(grandFather);

                } else {
                    if (item.isLeftChild()) {
                        ziq(item, parent);
                    } else if (item.isRightChild()) {
                        zaq(item, parent);
                    }
                    updateItemSum(parent);
                }
            }
            treeHeadIndex = item.index;

        }

        public SplayTreeItem get(int i) {
            return items.get(i);
        }

        public void updateItemSum(SplayTreeItem item) {
            item.sum = item.key;
            if (item.left != -1) {
                item.sum += items.get(item.left).sum;
            }
            if (item.right != -1) {
                item.sum += items.get(item.right).sum;
            }
        }

        private SplayTreeItem find(int key, int index) {
            SplayTreeItem item = items.get(index);
            if (key == item.key) {
                splay(item);
                return item;
            } else if (key < item.key) {
                if (item.left != -1) {
                    return find(key, item.left);
                } else {
                    splay(item);
                    return null;
                }
            } else if (key > item.key) {
                if (item.right != -1) {
                    return find(key, item.right);
                } else {
                    splay(item);
                    return null;
                }
            }
            return null;
        }

        private SplayTreeItem insert(int key, int index) {
            if (items.isEmpty()) {
                SplayTreeItem treeItem = new SplayTreeItem(key, -1, -1, -1, 0, NOT_A_CHILD);
                items.add(treeItem);
            }

            SplayTreeItem item = items.get(index);
            if (key == item.key) {
                splay(item);
                return item;
            } else if (key < item.key) {
                if (item.left != -1) {
                    return insert(key, item.left);
                } else {
                    SplayTreeItem treeItem = new SplayTreeItem(key, item.index, -1, -1, items.size(), LEFT);
                    item.left = items.size();
                    items.add(treeItem);
                    splay(treeItem);
                    return treeItem;
                }
            } else if (key > item.key) {
                if (item.right != -1) {
                    return insert(key, item.right);
                } else {
                    SplayTreeItem treeItem = new SplayTreeItem(key, item.index, -1, -1, items.size(), RIGHT);
                    item.right = items.size();
                    items.add(treeItem);
                    splay(treeItem);
                    return treeItem;
                }
            }
            return null;

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

        int sum;

        public SplayTreeItem(int key, int parent, int left, int right, int index, ChildType childType) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.index = index;
            this.childType = childType;
            this.sum = key;
        }

        public int getSum() {
            return sum;
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

    public SplayTree[] split(SplayTree tree, int key) {
        tree.find(key);

        SplayTreeItem head = tree.getHead();
        if (head.key <= key) {
            SplayTreeItem rightTreeHead = tree.get(head.right);
            rightTreeHead.parent = -1;
            rightTreeHead.childType = NOT_A_CHILD;

            head.right = -1;

            tree.updateItemSum(tree.getHead());

            SplayTree rightTree = new SplayTree(rightTreeHead.index, treeItems);
            return new SplayTree[]{tree, rightTree};
        } else {

            SplayTreeItem leftTreeHead = tree.get(head.left);
            leftTreeHead.parent = -1;
            leftTreeHead.childType = NOT_A_CHILD;

            head.left = -1;

            tree.updateItemSum(tree.getHead());

            SplayTree leftTree = new SplayTree(leftTreeHead.index, treeItems);
            return new SplayTree[]{leftTree, tree};
        }

    }

    public SplayTree merge(SplayTree tree1, SplayTree tree2) {
        SplayTreeItem tree1Max = tree1.getMax();
        tree1.splay(tree1Max);
        tree1.getHead().right = tree2.getHead().index;
        tree2.getHead().childType = RIGHT;
        tree2.getHead().parent = tree1.getHead().index;

        tree1.updateItemSum(tree1.getHead());
        return tree1;
    }

    public void remove(SplayTree tree, SplayTreeItem item) {
        tree.splay(item);

        SplayTreeItem leftItem = tree.get(item.left);
        SplayTreeItem rightItem = tree.get(item.right);

        item.left = -1;
        item.right = -1;

        leftItem.parent = -1;
        leftItem.childType = NOT_A_CHILD;
        rightItem.parent = -1;
        rightItem.childType = NOT_A_CHILD;

        SplayTree leftTree = new SplayTree(leftItem.index, treeItems);
        SplayTree rightTree = new SplayTree(rightItem.index, treeItems);

        merge(leftTree, rightTree);
    }

    public int getSum(SplayTree tree, int l, int r) {
        SplayTree[] lSplitTrees = split(tree, l - 1);
        SplayTree leftTree = lSplitTrees[0];
        SplayTree rightTree = lSplitTrees[1];

        SplayTree[] rSplitTrees = split(rightTree, r);
        SplayTree resTree = rSplitTrees[0];
        int resSum = resTree.getHead().getSum();

        SplayTree rMergeTree = merge(rSplitTrees[0], rSplitTrees[1]);
        tree = merge(leftTree, rMergeTree);

        return resSum;
    }


}
