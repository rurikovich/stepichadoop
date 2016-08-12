package cs_algo_theory_and_practice_methods.task3_2;

import java.util.*;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo3_2__6 {

    public static final String ZERO = "0";
    public static final String ONE = "1";

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        Map<String, String> encodedMap = new HashMap<>();

        int k = reader.nextInt();
        int l = reader.nextInt();
        for (int i = 0; i < k; i++) {
            String key = reader.next();
            String value = reader.next();

            encodedMap.put(key.substring(0,key.length()-1),value);
        }
        String encodedStr = reader.next();

        String decodedStr = process(encodedStr, encodedMap);

        System.out.println(decodedStr);
    }

    //    0 10 0 110 0 10 0 111
//    a b  a c   a b  a d
    public static String process(String encodedStr, Map<String, String> encodedMap) {
        StrongBinaryTree tree = buildTree(encodedMap);
        String res = "";
        Item currentItem = tree.getHead();
        for (String c : (encodedStr + " ").split("")) {
            String value = currentItem.getValue();
            if (value != null) {
                res += value;
                currentItem = tree.getHead();
            }
            if (c.equals(ZERO)) {
                currentItem = currentItem.getLeft();
            }
            if (c.equals(ONE)) {
                currentItem = currentItem.getRight();
            }


        }

        return res;
    }

    private static StrongBinaryTree buildTree(Map<String, String> encodedMap) {
        StrongBinaryTree tree = new StrongBinaryTree(new Item());
        Item currentItem = tree.getHead();

        for (Map.Entry<String, String> e : encodedMap.entrySet()) {
            String letter = e.getKey();
            String path = e.getValue();
            currentItem = tree.getHead();

            for (int i = 0; i < path.length(); i++) {
                String l = path.substring(i, i + 1);
                if (l.equals(ZERO)) {
                    if (currentItem.getLeft() == null) {
                        currentItem.setLeft(createItem(letter, path, i));
                    }
                    currentItem = currentItem.getLeft();
                }
                if (l.equals(ONE)) {
                    if (currentItem.getRight() == null) {
                        currentItem.setRight(createItem(letter, path, i));
                    }
                    currentItem = currentItem.getRight();
                }
            }
        }
        return tree;
    }

    private static Item createItem(String letter, String path, int i) {
        Item item = new Item();
        if (i == path.length() - 1) {
            item.setValue(letter);
        }
        return item;
    }


    private static class StrongBinaryTree {
        private Item head;

        public StrongBinaryTree(Item mHead) {
            head = mHead;
        }

        public Item getHead() {
            return head;
        }

    }

    private static class Item {
        private String value;

        private Item left;
        private Item right;


        public String getValue() {
            return value;
        }

        public Item getLeft() {
            return left;
        }

        public Item getRight() {
            return right;
        }

        public void setLeft(Item left) {
            this.left = left;
        }

        public void setRight(Item right) {
            this.right = right;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
