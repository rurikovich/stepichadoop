package cs_algo_theory_and_practice_methods_2.task1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rurik on 14.06.2016.
 */
public class CsAlgo2_1_2__5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        int m = reader.nextInt();

        ArrayList<Integer> maxs = getMaxs(n, arr, m);
        maxs.forEach(max -> System.out.print(max + " "));
    }

    static ArrayList<Integer> getMaxs(int n, int[] arr, int m) {
        ArrayList<Integer> maxs = new ArrayList<>();
        QueryWithMax queryWithMax = new QueryWithMax();
        for (int i = 0; i < n; i++) {
            queryWithMax.add(arr[i]);
            if (queryWithMax.size() == m) {
                maxs.add(queryWithMax.max());
                queryWithMax.poll();
            }
        }
        return maxs;
    }

    static class QueryWithMax {
        StackWithMax inputStack = new StackWithMax();
        StackWithMax outputStack = new StackWithMax();

        public int poll() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.pop();
        }

        public void add(int value) {
            inputStack.push(value);
        }

        public int max() {
            if (inputStack.isEmpty()) {
                return outputStack.max();
            } else if (outputStack.isEmpty()) {
                return inputStack.max();
            }
            return Math.max(inputStack.max(), outputStack.max());
        }

        public int size() {
            return inputStack.size() + outputStack.size();
        }
    }

    static class StackWithMax {
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

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public int size() {
            return stack.size();
        }


    }

}
