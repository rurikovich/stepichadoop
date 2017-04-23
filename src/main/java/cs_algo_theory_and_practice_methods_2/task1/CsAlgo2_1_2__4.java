package cs_algo_theory_and_practice_methods_2.task1;

import java.util.Scanner;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_1_2__4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        StackWithMax stackWithMax = new StackWithMax();

        int n = reader.nextInt();
        for (int i = 0; i < n; i++) {
            String command = reader.next();
            if (command.equals("push")) {
                stackWithMax.push(reader.nextInt());
            }
            if (command.equals("pop")) {
                stackWithMax.pop();
            }
            if (command.equals("max")) {
                System.out.println(stackWithMax.max());
            }
        }
    }
}
