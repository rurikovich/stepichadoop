package cs_algo_theory_and_practice_methods_2.task1;

import java.util.Scanner;
import java.util.Stack;

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
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {

        }
        return 0;
    }
}
