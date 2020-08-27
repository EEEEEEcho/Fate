package com.qiye;

import java.util.Scanner;
import java.util.Stack;

public class ComplateParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if(s == ""){
            System.out.println(0);
        }
        int count = 0;
        char characters[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i < characters.length;i ++){
            if(characters[i] ==')'){
                if(stack.size() == 0){
                    count ++;
                }
                else {
                    stack.pop();
                }

            }
            else {
                stack.push(characters[i]);
            }
        }
        System.out.println(stack.size() + count);
    }
}
