package com.code;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        System.out.println(list);
//        int n = 10;
//        int arr[] = new int[11];
//
//        for(int i = 1;i <= n;i ++){
//            int j = i;
//            while(j <= n){
//                arr[j] += 1;
//                j = j + i;
//            }
//        }
//        for(int i=1;i <=n;i ++){
//            System.out.print(arr[i] + " ");
//        }
//        String name = System.class.getSimpleName();
//        System.out.println(name);
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        System.out.println(stack.size());
        stack.pop();
        //System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
