package cs_algo_theory_and_practice_methods_2.task4;

import java.util.ArrayList;
import java.util.Scanner;

class CsAlgo2_4_4 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();

        SearchTree tree = new SearchTree();

        ArrayList<String> commands = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            commands.add(reader.next());
        }

        System.out.println();
    }


    static class SearchTree {
        ArrayList<TreeItem> items = new ArrayList<>();

        public TreeItem find(int key) {
            return find(key, 0);
        }

        public void insert(int key) {
            insert(key, 0);
        }

        public void delete(int key) {
            delete(key, 0);
        }


        private TreeItem find(int key, int i) {
            TreeItem item = items.get(i);
            if (key == item.key) {
                return item;
            } else if (item.left != -1 && key < item.key) {
                return find(key, item.left);
            } else if (item.right != -1 && key > item.key) {
                return find(key, item.right);
            }
            return null;
        }

        private void insert(int key, int i) {
            TreeItem item = items.get(i);
            if (key < item.key) {
                if (item.left != -1) {
                    insert(key, item.left);
                } else {
                    addLeftLeaf(item, i, key);
                }
            } else if (key >= item.key) {
                if (item.right != -1) {
                    insert(key, item.right);
                } else {
                    addRightLeaf(item, i, key);
                }
            }

        }

        private void delete(int key, int i) {
            TreeItem item = items.get(i);
            if (key == item.key) {
                deleteLeafOrItemWithOneChild(item);
                if (item.hasBothChilds()) {
                    TreeItem leftMaxItem = findLeftMaxItem(item);
                    swichItems(item, leftMaxItem);
                    deleteLeafOrItemWithOneChild(item);
                }
            } else if (key < item.key && item.left != -1) {
                delete(key, item.left);
            } else if (key > item.key && item.right != -1) {
                delete(key, item.right);
            }
        }

        private void deleteLeafOrItemWithOneChild(TreeItem item) {
            if (item.isLeaf()) {
                deleteLeaf(item);
            }
            if (item.hasOnlyOneChild()) {
                deleteItemWithOneChild(item);
            }
        }

        private void swichItems(TreeItem item1, TreeItem item2) {
            int item2ParentIndex = item2.parent;
            int item2LeftChildIndex = item2.left;
            int item2RightChildIndex = item2.right;

            TreeItem item1Parent = items.get(item1.parent);
            updateChildIndexOfParent(item1Parent, item1.currentIndex, item2.currentIndex);
            item2.left = item1.left;
            item2.right = item1.right;

            TreeItem item2Parent = items.get(item2ParentIndex);
            updateChildIndexOfParent(item2Parent, item2.currentIndex, item1.currentIndex);
            item1.left = item2LeftChildIndex;
            item1.right = item2RightChildIndex;
        }

        private TreeItem findLeftMaxItem(TreeItem item) {
            TreeItem leftMaxItem = items.get(item.left);
            while (leftMaxItem.right != -1) {
                leftMaxItem = items.get(leftMaxItem.right);
            }
            return leftMaxItem;
        }

        private void deleteItemWithOneChild(TreeItem item) {
            TreeItem parentItem = items.get(item.parent);
            if (item.left != -1) {
                updateChildIndexOfParent(parentItem, item.currentIndex, item.left);
                updateIndexOfParent(item.left, item.parent);
            }
            if (item.right != -1) {
                updateChildIndexOfParent(parentItem, item.currentIndex, item.right);
                updateIndexOfParent(item.right, item.parent);
            }
        }

        private void updateIndexOfParent(Integer itemIndex, Integer newParent) {
            TreeItem item = items.get(itemIndex);
            item.parent = newParent;
        }

        private void updateChildIndexOfParent(TreeItem parentItem, Integer oldChildIndex, Integer newChildIndex) {
            if (parentItem.left == oldChildIndex) {
                parentItem.left = newChildIndex;
            } else if (parentItem.right == oldChildIndex) {
                parentItem.right = newChildIndex;
            }
        }

        private void deleteLeaf(TreeItem item) {
            TreeItem parentItem = items.get(item.parent);
            Integer currentIndex = item.currentIndex;
            if (parentItem.left == currentIndex) {
                parentItem.left = -1;
            } else if (parentItem.right == currentIndex) {
                parentItem.right = -1;
            }
        }

        private void addLeftLeaf(TreeItem item, int itemIndex, int key) {
            addNewItem(key, itemIndex);
            item.left = items.size() - 1;
        }

        private void addRightLeaf(TreeItem item, int itemIndex, int key) {
            addNewItem(key, itemIndex);
            item.right = items.size() - 1;
        }

        private void addNewItem(int key, int parent) {
            TreeItem newItem = new TreeItem(key, parent, -1, -1, items.size());
            items.add(newItem);
        }
    }

    static class TreeItem {
        Integer key;
        Integer parent;
        Integer left;
        Integer right;
        final Integer currentIndex;

        public TreeItem(Integer key, Integer parent, Integer left, Integer right, Integer currentIndex) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.currentIndex = currentIndex;
        }

        public boolean isLeaf() {
            return left == -1 && right == -1;
        }

        public boolean hasOnlyOneChild() {
            return (left != -1 && right == -1) || (left == -1 && right != -1);
        }

        public boolean hasBothChilds() {
            return left != -1 && right != -1;
        }
    }

}