package com.qiye;

import java.util.Scanner;
import java.util.Stack;

public class PrimeAndCircleNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int count = 0;
        for(int i = x;i <=y;i ++){
            boolean isPrime = false;
            boolean isCircle = false;
            isPrime = judgePrime(i);
            isCircle = judgeCircle(i);
//            System.out.println("现在的i是:" + i +" 它是素数吗? " + isPrime + " 它是回文数吗? " + isCircle);
            if(isPrime && isCircle){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean judgePrime(int num){
        if(num < 2) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        for(int i=3;i*i <= num;i += 2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean judgeCircle(int num){
        String s = num + "";
        char characters[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i < characters.length;i ++){
            stack.push(characters[i]);
        }
        String s1 = "";
        while (!stack.isEmpty()){
            s1 += stack.pop();
        }
        if(s1.equals(s)){
            return true;
        }
        return false;
    }
}
