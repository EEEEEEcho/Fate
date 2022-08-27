package com.code.EveryDay;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean alive = true;   //当前行星是否能存活
            while (alive && asteroids[i] < 0 && !stack.isEmpty() && stack.peek() > 0){
                //当前行星是反方向的，如果当前行星的速度比栈顶行星的速度大,那么它就能活
                alive = Math.abs(asteroids[i]) > stack.peek();
                //如果当前行星的速度与栈顶行星速度相同
                if (Math.abs(asteroids[i]) >= stack.peek()){
                    //栈顶那个也活不了
                    stack.pop();
                }
            }
            //如果当前行星能活下来，就让它入栈,它可能的值是一个正数或者极大的负数
            if (alive){
                stack.push(asteroids[i]);
            }
        }
        int[] ans = new int[stack.size()];
        int i = stack.size() - 1;
        while (i >= 0){
            ans[i --] = stack.pop();
        }
        return ans;
    }
}
