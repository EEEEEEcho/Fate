package com.theswordreferstooffer.offer;

import java.util.Stack;

public class StackMin {
    /**
     * 我自己的方式，定义一个变量保存最小值。
     */
    private Stack<Integer> stack = new Stack<>();
    private int min;

    public void push(int node) {
        if (stack.size() == 0) {
            stack.push(node);
            this.min = node;
        } else {
            if (node < min) {
                this.min = node;
            }
            stack.push(node);
        }
    }

    public void pop() {
        int top = stack.peek();
        //System.out.println(stack.size());
        if (top == min) {
            stack.pop();
            //System.out.println(stack.size());
            int n = 0;
            int tmpMin = Integer.MAX_VALUE;
            while (n < stack.size()) {
                int tmp = stack.get(n);
                //System.out.println(tmp);
                if (tmp < tmpMin) {
                    tmpMin = tmp;
                }
                n++;
            }
            this.min = tmpMin;
        } else {
            stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return this.min;
    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();
        stackMin.push(3);
        System.out.println(stackMin.min());
        stackMin.push(4);
        System.out.println(stackMin.min());
        stackMin.push(2);
        System.out.println(stackMin.min());
        stackMin.push(3);
        System.out.println(stackMin.min());
        stackMin.pop();
        System.out.println(stackMin.min());
        stackMin.pop();
        System.out.println(stackMin.min());
        stackMin.pop();
        System.out.println(stackMin.min());
        stackMin.push(0);
        System.out.println(stackMin.min());
    }
}
