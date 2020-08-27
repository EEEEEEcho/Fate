package com.theswordreferstooffer.offer;
import java.util.Stack;
/**
 * 书中解法，定义两个栈，其中一个保存最小值
 */
public class StackMin2 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
        }
        else{
            if(stack2.peek() > node){
                stack2.push(node);
            }
        }
    }

    public void pop() {
        if(stack1.pop() == stack2.peek()){
            //如果pop的是最小值，那么最小值栈也pop
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
