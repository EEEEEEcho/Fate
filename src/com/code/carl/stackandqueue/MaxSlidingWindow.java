package com.code.carl.stackandqueue;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public static class MaxQueue{
        private Deque<Integer> deque = new ArrayDeque<>();
        public MaxQueue(){

        }
        //该队列是单调递减的，所以从后往前找，去掉所有小于x的元素
        public void push(int x){
            while (!deque.isEmpty() && deque.getLast() < x){
                deque.removeLast();
            }
            deque.addLast(x);
        }
        //如果x与队列的第一个元素相同，那么就证明它是最大的，当前窗口滑过了，要被移除了
        //否则的话，证明元素在当前窗口中不是最大的,无需移除
        public void pop(int x){
            if (deque.getFirst() == x){
                deque.removeFirst();
            }
        }
        //单调递减的队列的队头是最大的
        public int getMax(){
            return deque.getFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        int index = 0;
        MaxQueue maxQueue = new MaxQueue();
        while (right < nums.length){
            maxQueue.push(nums[right]);
            if (right - left == k - 1){
                result[index ++] = maxQueue.getMax();
                maxQueue.pop(nums[left]);
                left ++;
            }
            right ++;
        }
        return result;
    }
}
