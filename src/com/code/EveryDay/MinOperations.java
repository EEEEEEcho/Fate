package com.code.EveryDay;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MinOperations {
    public int minOperations(String[] logs) {
        Deque<String> stack =  new ArrayDeque<>();
        stack.push("Main");
        for (String log : logs){
            if (log.equals("./")){
                continue;
            }
            else if(log.equals("../")){
                String top = stack.peek();
                if (top.equals("Main")){
                    continue;
                }
                else {
                    stack.pop();
                }
            }
            else {
                stack.push(log);
            }
        }
        return stack.size() - 1;
    }

    public static void main(String[] args) {
        List list = new ArrayList<Integer>();
        list.add("s");
        list.add("d");
        System.out.println(list.get(1));
    }
}
