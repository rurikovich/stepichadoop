package cs_algo_theory_and_practice_methods.task3_2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo3_2__5 {
    private static Map<String, String> encodeMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String str = reader.next();

        String encodedStr = process(str);

        System.out.print(encodeMap.keySet().size() + " ");
        System.out.println(encodedStr.length());
        encodeMap.keySet().forEach(k -> System.out.println(k + ": " + encodeMap.get(k)));
        System.out.println(encodedStr);


    }

    public static String process(String str) {
        if (str.length() == 1) {
            encodeMap.put(str, "0");
            return "0";
        }
        Map<String, Integer> charsFrequencies = getCharsFrequencies(str);
        encodeMap = getEncodeMap(charsFrequencies);
        StringBuilder encodedStr = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            String ch = str.substring(i, i + 1);
            encodedStr.append(encodeMap.get(ch));
        }
        return encodedStr.toString();
    }

    private static Map<String, String> getEncodeMap(Map<String, Integer> charsFrequencies) {
        Map<String, String> res = new HashMap<>();
        if (charsFrequencies.keySet().size() == 1) {
            String str = (String) charsFrequencies.keySet().toArray()[0];
            res.put(str, "0");
            return res;
        }

        StrongBinaryTree sbTree = buildTree(charsFrequencies);
        StringBuilder code = new StringBuilder("");
        Item currentItem = sbTree.getHead();
        boolean isToLeft = true;
        Set<String> charsToProcess = charsFrequencies.keySet();

        while (!charsToProcess.isEmpty()) {
            if (currentItem.getValue() == null) {
                currentItem = isToLeft ? currentItem.getLeft() : currentItem.getRight();
                code.append(isToLeft ? "0" : "1");
                isToLeft = !isToLeft;
            } else {
                String value = currentItem.getValue();
                res.put(value, code.toString());
                code.deleteCharAt(code.length() - 1);
                charsToProcess.remove(value);
                currentItem = currentItem.getParent();
            }
        }
        return res;
    }

    private static Map<String, Integer> getCharsFrequencies(String str) {
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            String c = str.substring(i, i + 1);
            if (!res.containsKey(c)) {
                res.put(c, 1);
            } else {
                res.put(c, res.get(c) + 1);
            }
        }
        return res;
    }

    private static StrongBinaryTree buildTree(Map<String, Integer> charsFrequencies) {
        StrongBinaryTree sbTree = new StrongBinaryTree();
        PriorityQueue<Item> priorityQueue = createItemPriorityQueue(charsFrequencies);
        while (priorityQueue.size()>=2) {
            Item l = priorityQueue.poll();
            Item r = priorityQueue.poll();
            Item head = new Item(l.getF() + r.getF(), l, r);
            l.setParent(head);
            r.setParent(head);
            priorityQueue.add(head);
            sbTree.setHead(head);
        }
        return sbTree;
    }

    private static PriorityQueue<Item> createItemPriorityQueue(Map<String, Integer> charsFrequencies) {
        PriorityQueue<Item> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.getF().compareTo(o2.getF()));
        Set<Item> items = charsFrequencies.entrySet().stream().map(e -> new Item(e.getKey(), e.getValue())).collect(Collectors.toSet());
        priorityQueue.addAll(items);
        return priorityQueue;
    }


    private static class StrongBinaryTree {
        private Item head;

        public Item getHead() {
            return head;
        }

        public void setHead(Item head) {
            this.head = head;
        }
    }

    private static class Item {
        private String value;
        private Integer f;

        private Item left;
        private Item right;
        private Item parent;

        public Item(String value, Integer f) {
            this.value = value;
            this.f = f;
        }

        public Item(Integer f, Item left, Item right) {
            this.f = f;
            this.left = left;
            this.right = right;
        }

        public String getValue() {
            return value;
        }

        public Integer getF() {
            return f;
        }

        public Item getLeft() {
            return left;
        }

        public Item getRight() {
            return right;
        }

        public Item getParent() {
            return parent;
        }

        public void setParent(Item parent) {
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left != null && right != null;
        }
    }

}
