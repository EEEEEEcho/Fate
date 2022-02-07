package com.theswordreferstooffer.offer;

import java.util.Stack;

public class TwoStackLikeQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 两杯水，倒过来，倒过去
     * @param node
     */
    public void push(int node){
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }
    public int pop(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /***
     * 书上解法
     * @param node
     */
    public void push1(int node){
        stack1.push(node);
    }
    public int pop1(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
