package cs_algo_theory_and_practice_methods.task3_2;

import java.util.*;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo3_2__5 {
    private static Map<String, String> encodeMap;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String str = reader.next();

        String encodedStr = process(str);

        System.out.print(encodeMap.keySet().size());
        System.out.println(encodedStr.length());
        encodeMap.keySet().forEach(k -> System.out.println(k + ":" + encodeMap.get(k)));
        System.out.println(encodedStr);


    }

    public static String process(String str) {
        if (str.length() == 1) {
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
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        priorityQueue.addAll(charsFrequencies.entrySet());

        StrongBinaryTree sbTree = new StrongBinaryTree();
        while (!priorityQueue.isEmpty()) {
            if (sbTree.getHead() == null) {
                Item l = pollAndCreateItem(priorityQueue);
                Item r = pollAndCreateItem(priorityQueue);
                Item head = new Item(l.getF() + r.getF(), l, r);
                l.setParent(head);
                r.setParent(head);
                sbTree.setHead(head);
            } else {
                Item l = pollAndCreateItem(priorityQueue);
                Item r = sbTree.getHead();
                Item newHead = new Item(l.getF() + r.getF(), l, r);
                l.setParent(newHead);
                r.setParent(newHead);
                sbTree.setHead(newHead);
            }
        }

        return sbTree;
    }

    private static Item pollAndCreateItem(PriorityQueue<Map.Entry<String, Integer>> priorityQueue) {
        Map.Entry<String, Integer> e = priorityQueue.poll();
        return new Item(e.getKey(), e.getValue());
    }


}
