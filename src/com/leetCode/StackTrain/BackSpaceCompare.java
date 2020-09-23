package com.leetCode.StackTrain;

import java.util.Stack;

public class BackSpaceCompare {
//    public boolean backspaceCompare(String S, String T) {
//        char[] array1 = S.toCharArray();
//        char[] array2 = T.toCharArray();
//        Stack stack1 = new Stack();
//        Stack stack2 = new Stack();
//        for(int i=0;i < array1.length;i ++){
//            if(array1[i] == '#'){
//                if(stack1.isEmpty()){
//                    continue;
//                }
//                stack1.pop();
//            }
//            else{
//                stack1.push(array1[i]);
//            }
//        }
//        for(int i=0;i < array2.length;i ++){
//            if(array2[i] == '#'){
//                if(stack2.isEmpty()){
//                    continue;
//                }
//                stack2.pop();
//            }
//            else{
//                stack2.push(array2[i]);
//            }
//        }
//        String result1 = "";
//        String result2 = "";
//        while (!stack1.isEmpty()){
//            result1 += stack1.pop();
//        }
//        while (!stack2.isEmpty()){
//            result2 += stack2.pop();
//        }
//        return result1.equals(result2);
//    }
    public boolean backspaceCompare(String S, String T) {
        return getResult(S).equals(getResult(T));
    }
    public String getResult(String s){
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c != '#'){
                stack.push(c);
            }
            else{
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        return stack.toString();
    }
    public static void main(String[] args) {
        BackSpaceCompare backSpaceCompare = new BackSpaceCompare();
        System.out.println(backSpaceCompare.backspaceCompare("ab##","c#d#"));
    }
}
