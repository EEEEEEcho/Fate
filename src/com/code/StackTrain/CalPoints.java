package com.code.StackTrain;

import java.util.Stack;

public class CalPoints {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int validScore = 0;
        for(String s : ops){
            if(s.equals("+")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                validScore = n1 + n2;
                sum += validScore;
                stack.push(n2);
                stack.push(n1);
                stack.push(validScore);
                //System.out.println(sum);
            }
            else if(s.equals("D")){
                validScore = stack.peek() * 2;
                sum += validScore;
                //System.out.println(sum);
                stack.push(validScore);
            }
            else if(s.equals("C")){
                int cancel = stack.pop();
                sum -= cancel;
                //stack.push(0);
            }
            else{
                validScore = Integer.valueOf(s);
                sum += validScore;
                //System.out.println(sum);
                stack.push(validScore);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        CalPoints c = new CalPoints();
        String s[] = {"5","2","C","D","+"};
        int sum = c.calPoints(s);
        System.out.println(sum);
    }
}
