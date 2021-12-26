package com.labuladong.chapter1.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxSlidingWindow {

    //单调递减的单调队列
    class MonotonicQueue{
        LinkedList<Integer> queue = new LinkedList<>();
        public void push(int n){
            //将小于n的所有元素全部删除
            while (!queue.isEmpty() && queue.getLast() < n){
                queue.pollLast();
            }
            queue.addLast(n);
        }
        public int max(){
            return queue.getFirst();
        }
        public void pop(int n){
            if (queue.getFirst() == n){
                queue.pollFirst();
            }
        }
    }

    /**
     * 在⼀堆数字中，已知最值为A，如果给这堆数添加⼀个数B，那么⽐较⼀下 A 和 B 就可以⽴即算出新的最值
     * 但如果减少⼀个数，就不能直接得到最值了，因为如果减少的这个数恰好是 A，就需要遍历所有数重新找新的最值
     * 我只考虑了单调递增，应该考虑的是单调递减
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        int left = 0;
        int right = 0;
        int[] result = new int[nums.length - k + 1];
        int i = 0;
        while (right < nums.length){
            queue.push(nums[right]);
            if (right - left + 1 == k){
                result[i++] = queue.max();
                queue.pop(nums[left]);
                left++;
            }
            right ++;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow m = new MaxSlidingWindow();
        m.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        //m.maxSlidingWindow(new int[]{1},1);
//        Deque<Integer> deque = new LinkedList<>();
//        deque.offer(3);
//        deque.peekLast();
//        System.out.println(deque.size());
    }
}
