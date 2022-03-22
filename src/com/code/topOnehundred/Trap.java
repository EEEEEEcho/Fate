package com.code.topOnehundred;

import java.util.Arrays;
import java.util.LinkedList;

public class Trap {
    //1.单调栈
    public int trap1(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        int sum = 0;
        int current = 0;
        while (current < height.length){
            //将比当前高度小的移出去
            while (!stack.isEmpty() && height[current] > height[stack.peek()]){
                //记录一下当前高度
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()){
                    //栈空，跳出循环，就意味着当前只有右边的墙没有左边的墙
                    break;
                }
                //计算两者之间的距离
                //找到左边的墙，因为按照算法的执行流程，肯定会有一个左边的墙
                int leftWall = stack.peek();
                int distance = current - leftWall - 1;
                sum += distance * (Math.min(height[leftWall], height[current]) - h);
            }
            stack.push(current);
            current ++;
        }

        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(1e9);
//        System.out.println(Integer.MAX_VALUE);
        Integer i1 = 40;
        Integer i2 = new Integer(40);
        Integer i3 = 40;
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
        System.out.println(i1.equals(i2));
    }
}
