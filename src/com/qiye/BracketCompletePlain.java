package com.qiye;

import java.util.Scanner;
import java.util.Stack;

public class BracketCompletePlain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String s = scanner.nextLine();
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        int result = 1;
        for(int i=0;i < sb.length();i ++){
            int index = -1;
            if(sb.charAt(i) == '('){
                sb.deleteCharAt(i);
                StringBuilder tmp = new StringBuilder(sb.toString());
                for(int j=tmp.length() - 1; j >= 1;j --){
                    if(tmp.charAt(j) == ')'){
                        tmp.deleteCharAt(j);
                        //System.out.println(tmp);
                        if(isComplete(tmp.toString(),stack)){
                            index = j;
                            count ++;
                        }
                        //有问题
                        tmp.insert(j,")");
                        System.out.println(tmp);
                    }
                }
                sb.deleteCharAt(index);
                result *= count;
            }
        }
        System.out.println(result);
    }
    public static boolean isComplete(String s, Stack<Character> stack){
        stack.clear();
        for(int i=0;i < s.length();i ++){
            char x = s.charAt(i);
            if(x == '('){
                stack.push(x);
            }
            else {
                stack.pop();
            }
        }
        if(stack.size() == 0){
            return true;
        }
        else {
            return false;
        }
    }
}
