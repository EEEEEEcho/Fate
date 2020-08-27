package com.leetCode;

import java.util.Stack;

/**
 *  ==是判断两个变量或实例是不是指向同一个内存空间，equals是判断两个变量或实例所指向的内存空间的值是不是相同
 *  ==是指对内存地址进行比较 ， equals()是对字符串的内容进行比较
 *  ==指引用是否相同， equals()指的是值是否相同
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for(int i = 0;i < tokens.length;i ++){
            //System.out.println(tokens[i]);
            if(tokens[i].equals("+")){
                int x1 = nums.pop();
                int x2 = nums.pop();
                int re = x1 + x2;
                nums.push(re);
            }
            else if(tokens[i].equals("-")){
                int x1 = nums.pop();
                int x2 = nums.pop();
                int re = x2 - x1;
                nums.push(re);
            }
            else if(tokens[i].equals("*")){
                int x1 = nums.pop();
                int x2 = nums.pop();
                int re = x1 * x2;
                nums.push(re);
            }
            else if(tokens[i].equals("/")){
                int x1 = nums.pop();
                int x2 = nums.pop();
                int re = x2 / x1;
                nums.push(re);
            }
            else{
                nums.push(Integer.parseInt(tokens[i]));
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        String s[] = {"3","-4","+"};
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
        System.out.println(e.evalRPN(s));
    }
}
