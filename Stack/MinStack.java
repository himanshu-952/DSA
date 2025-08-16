package StackAndQueue;
import java.util.*;

public class MinStack {
    private ArrayList<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.add(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int removed = stack.remove(stack.size() - 1);
        if (!minStack.isEmpty() && removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}
