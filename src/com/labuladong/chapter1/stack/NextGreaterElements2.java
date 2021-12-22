package com.labuladong.chapter1.stack;

import java.util.LinkedList;

public class NextGreaterElements2 {
    //笨办法，内存消耗太大
    public int[] nextGreaterElements(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] tmp = new int[nums.length * 2];
        System.arraycopy(nums,0,tmp,0,nums.length);
        System.arraycopy(nums,0,tmp,nums.length,nums.length);
        int[] ans = new int[nums.length * 2];
        int[] res = new int[nums.length];
        for (int i = tmp.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= tmp[i]){
                stack.pop();
            }
            //当前栈中最大的元素
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(tmp[i]);
        }
        System.arraycopy(ans, 0, res, 0, res.length);
        return res;
    }

    //利用取余数的办法，模拟双倍数组长度
    public int[] nextGreaterElements2(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] ans = new int[nums.length];
        int n = nums.length;
        for (int i = n * 2 - 1; i >=0 ; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]){
                stack.pop();
            }
            ans[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return ans;
    }
}
