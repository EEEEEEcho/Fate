package com.labuladong.chapter1.stack;

import java.util.LinkedList;

public class MinInsertions {
    //没有过
    public int minInsertions(String s) {
        char[] charArray = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        int right = 0;
        int left = 0;
        for (char c : charArray) if (c == ')') stack.push(c);
        for (char c : charArray){
            if(c == '('){
                if (stack.size() >= 2){
                    stack.pop();
                    stack.pop();
                }
                else if (stack.size() == 1){
                    right += 1;
                }
                else{
                    right += 2;
                }
            }
            else{
                if (!stack.isEmpty()){
                    stack.pop();
                    left += 1;
                }
            }
        }
        return right + left / 2;
    }

    //labuladong
    public int minInsertions1(String s) {
        int left = 0;   //需要的左括号的数量
        int right = 0;  //需要的右括号的数量
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                //如果遇到了左括号，那么就需要两个右括号
                right += 2;
                if (right % 2 == 1){
                    //如果需要的右括号的数量是奇数
                    //人工添加一个右括号（为什么不是++？因为right变量是需要的右括号的数量，我们手动添加一个右括号，那么需求的就少一个）
                    right --;
                    //加了一个右括号，右括号补成了偶数，那么需要的左括号就需要+1个
                    left ++;
                }
            }
            if (chars[i] ==')'){
                //字符串中有了一个(，需求的(就少一个
                right --;
                if (right == -1){
                    //左括号不够了，需要一个左括号
                    left ++;
                    //加一个左括号，就需要两个右括号，现在多出来了一个，还需要再来一个
                    right = 1;
                }
            }
        }
        return left + right;
    }


    public static void main(String[] args) {
        MinInsertions m = new MinInsertions();
        int i = m.minInsertions("))())(");
        System.out.println(i);
    }
}
