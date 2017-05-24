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
            if (items.isEmpty()) {
                createTreeHead(key);
                return;
            }
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

        private void createTreeHead(int key) {
            items.add(new TreeItem(key, -1, -1, -1, 0));
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
            updateParentsHeight(item.parent);
        }

        private void swichItems(TreeItem item1, TreeItem item2) {
            int item2ParentIndex = item2.parent;
            int item2LeftChildIndex = item2.left;
            int item2RightChildIndex = item2.right;
            int item2TreeHeight = item2.treeHeight;

            if (item1.parent != -1) {
                TreeItem item1Parent = items.get(item1.parent);
                updateChildIndexOfParent(item1Parent, item1.currentIndex, item2.currentIndex);
            }
            item2.left = item1.left;
            item2.right = item1.right;
            item2.treeHeight = item1.treeHeight;

            TreeItem item2Parent = items.get(item2ParentIndex);
            updateChildIndexOfParent(item2Parent, item2.currentIndex, item1.currentIndex);
            item1.left = item2LeftChildIndex;
            item1.right = item2RightChildIndex;
            item1.treeHeight = item2TreeHeight;
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
                if (item.parent != -1) {
                    updateChildIndexOfParent(parentItem, item.currentIndex, item.left);
                }
                updateIndexOfParent(item.left, item.parent);
            }
            if (item.right != -1) {
                if (item.parent != -1) {
                    updateChildIndexOfParent(parentItem, item.currentIndex, item.right);
                }
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
            if (item.parent == -1) {
                return;
            }
            TreeItem parentItem = items.get(item.parent);
            Integer currentIndex = item.currentIndex;
            if (parentItem.left == currentIndex) {
                parentItem.left = -1;
            } else if (parentItem.right == currentIndex) {
                parentItem.right = -1;
            }
        }

        private void addLeftLeaf(TreeItem item, int itemIndex, int key) {
            TreeItem treeItem = addNewItem(key, itemIndex);
            item.left = items.size() - 1;
            updateParentsHeight(treeItem.parent);
        }

        private void addRightLeaf(TreeItem item, int itemIndex, int key) {
            TreeItem treeItem = addNewItem(key, itemIndex);
            item.right = items.size() - 1;
            updateParentsHeight(treeItem.parent);
        }


        private void updateParentsHeight(Integer itemIndex) {
            if (itemIndex == -1) {
                return;
            }
            TreeItem item = items.get(itemIndex);
            int leftChildSubTreeHeight = (item.left != -1 ? items.get(item.left).treeHeight : 0) + 1;
            int rightChildSubTreeHeight = (item.right != -1 ? items.get(item.right).treeHeight : 0) + 1;

            item.treeHeight = Math.max(leftChildSubTreeHeight, rightChildSubTreeHeight) + 1;
            updateParentsHeight(item.parent);
        }

        private TreeItem addNewItem(int key, int parent) {
            TreeItem newItem = new TreeItem(key, parent, -1, -1, items.size());
            items.add(newItem);
            return newItem;
        }
    }

    static class TreeItem {
        Integer key;
        Integer parent;
        Integer left;
        Integer right;
        final Integer currentIndex;

        Integer treeHeight;

        public TreeItem(Integer key, Integer parent, Integer left, Integer right, Integer currentIndex) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.currentIndex = currentIndex;
            this.treeHeight = 1;
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