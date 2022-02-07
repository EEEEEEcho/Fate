package com.labuladong.chapter1.stack;

import java.util.HashMap;
import java.util.LinkedList;

public class NextGreaterElement {
    //单调栈，解决下一个更大元素的问题
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >=0 ; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            hashMap.put(nums2[i],stack.isEmpty()? -1: stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hashMap.get(nums1[i]);
        }
        return nums1;
    }

    public static void main(String[] args) {
        NextGreaterElement n = new NextGreaterElement();
        n.nextGreaterElement(new int[]{2,4},new int[]{1,2,3,4});
    }
}
