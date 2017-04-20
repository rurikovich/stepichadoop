package cs_algo_theory_and_practice_methods_2.task1;

import java.util.*;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_1__2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String str = reader.next();
        int res = new CsAlgo2_1__2().checkStr(str);
        System.out.println(res > 0 ? res : "Success");
    }

    int checkStr(String str) {
        HashMap<String, String> brackets = new HashMap<>();
        brackets.put("(", ")");
        brackets.put("{", "}");
        brackets.put("[", "]");

        Stack<Pair> stack = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            String bracket = str.substring(i, i + 1);
            if (brackets.containsKey(bracket)) {
                stack.push(new Pair(bracket, i));
            } else if (brackets.values().contains(bracket)) {
                if (stack.isEmpty() || !brackets.get(stack.pop().getBracket()).equals(bracket)) {
                    return i + 1;
                }
            }
            i++;
        }
        if (!stack.isEmpty()) {
            return stack.peek().getIndex() + 1;
        }
        return 0;
    }

    private class Pair {
        private String bracket;
        private int index;

        Pair(String bracket, int index) {
            this.bracket = bracket;
            this.index = index;
        }

        String getBracket() {
            return bracket;
        }

        int getIndex() {
            return index;
        }
    }
}
