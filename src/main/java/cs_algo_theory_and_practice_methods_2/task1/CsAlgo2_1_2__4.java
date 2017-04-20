package cs_algo_theory_and_practice_methods_2.task1;

import java.util.Scanner;
import java.util.Stack;

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

    private static class StackWithMax {
        private Stack<Integer> stack;
        private Stack<Integer> maxStack;

        StackWithMax() {
            this.stack = new Stack<>();
            this.maxStack = new Stack<>();
        }

        void push(int i) {
            int newMax = maxStack.isEmpty() ? i : Math.max(i, maxStack.peek());
            maxStack.push(newMax);
            stack.push(i);
        }

        int pop() {
            maxStack.pop();
            return stack.pop();
        }

        public int max() {
            return maxStack.peek();
        }


    }
}
