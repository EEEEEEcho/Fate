package com.leetCode.StackTrain;

import java.util.Stack;

public class RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {
        char array[] = S.toCharArray();
        //System.out.println(S);
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < array.length;i ++){
            if(array[i] == '('){
                stack.push(array[i]);
                //System.out.println(array[i]);
                tmp.append('(');
            }
            else if(array[i] == ')'){
                stack.pop();
                tmp.append(')');
            }
            if(stack.isEmpty()){
                //System.out.println(tmp);
                tmp.deleteCharAt(0);
                tmp.deleteCharAt(tmp.length() - 1);
                //System.out.println(tmp);
                result.append(tmp.toString());
                tmp = new StringBuilder();
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        RemoveOuterParentheses r = new RemoveOuterParentheses();
        String result = r.removeOuterParentheses("(()(()))");
        System.out.println(result);
    }
}
