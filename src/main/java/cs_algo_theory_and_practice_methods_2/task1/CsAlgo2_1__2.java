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

        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            String bracket = str.substring(i, i + 1);
            if (brackets.containsKey(bracket)) {
                stack.push(bracket);
            } else if (brackets.values().contains(bracket)) {
                if (stack.isEmpty() || !brackets.get(stack.pop()).equals(bracket)) {
                    return i + 1;
                }
            }
            i++;
        }
        if (!stack.isEmpty()) {
            return stack.size();
        }
        return 0;
    }
}
