package com.code.StackTrain;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Set<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");
        LinkedList<Integer> stack = new LinkedList<>();
        for (String str : tokens){
            if(!operations.contains(str)){
                stack.addFirst(Integer.parseInt(str));
            }
            else{
                if (stack.size() >= 2){
                    int y = stack.removeFirst();
                    int x = stack.removeFirst();
                    int result = ops(x,y,str);
                    stack.addFirst(result);
                }
            }
        }
        return stack.removeFirst();
    }

    private int ops(int x,int y,String ops){
        int ans = 0;
        switch (ops){
            case "+":
                ans = x + y;
                break;
            case "-":
                ans = x - y;
                break;
            case "*":
                ans = x * y;
                break;
            case "/":
                ans = x / y;
                break;
        }
        return ans;
    }
}
