package com.code.StackTrain;

import java.util.LinkedList;

public class QueueImiateStack {

    LinkedList<Integer> stack = null;
    /** Initialize your data structure here. */
    public QueueImiateStack() {
        stack = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        
        return stack.pop();
    }

    /** Get the top element. */
    public int top() {
        return stack.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
