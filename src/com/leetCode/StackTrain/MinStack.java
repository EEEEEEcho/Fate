package com.leetCode.StackTrain;

import java.util.LinkedList;
import java.util.Stack;

public class MinStack {
    /**
     * 这个方法很秀
     */
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(min >= x){
            //如果传过来的值比 min小，那么先把原来的min push进去，保留了第二小的元素。
            //这个思路真的很秀。 如果下次不理解， 手动模拟一边
            stack.push(min);
            min = x;
        }
        //然后再把传过来的push进来
        stack.push(x);
    }

    public void pop() {
        //先pop一次，看是否等于最小的，如果不是，就pop出去了。
        //如果是等于最小的。那就再pop一次，因为再pop的时候，min就置为第二小的了
        if(stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        Stack stack = new Stack<>();
        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.size());
        LinkedList s = new LinkedList();
        s.push(2);
        System.out.println(s.pop());
        System.out.println(s.size());
    }
}
