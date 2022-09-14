package com.code.carl.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        if (tokens ==  null || tokens.length == 0) return 0;
        HashSet<String> hashSet = new HashSet<>(Arrays.asList("+","-","*","/"));
        for (String s : tokens){
            if (!hashSet.contains(s)){
                stack.push(Integer.valueOf(s));
            }
            else {
                int x = stack.pop();
                int y = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(y + x);
                        break;
                    case "-":
                        stack.push(y - x);
                        break;
                    case "*":
                        stack.push(y * x);
                        break;
                    case "/":
                        stack.push(y / x);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        int i = evalRPN.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(i);
    }
}
