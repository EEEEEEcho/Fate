package com.labuladong.chapter1.stackandqueue;

import java.util.LinkedList;
import java.util.Stack;

public class MyQueue {
    private final LinkedList<Integer> stack1;
    private final LinkedList<Integer> stack2;
    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.size() == 0 && stack2.size() == 0;
    }
}
