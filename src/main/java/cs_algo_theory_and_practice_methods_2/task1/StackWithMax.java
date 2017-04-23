package cs_algo_theory_and_practice_methods_2.task1;

import java.util.Stack;

/**
 * Created by User on 23.04.2017.
 */
public class StackWithMax {
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