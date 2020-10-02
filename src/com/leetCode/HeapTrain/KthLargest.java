package com.leetCode.HeapTrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {
//    private int nums[] = null;
//    private int kth;
//    private ArrayList<Integer> arrayList = new ArrayList<>();
//    public KthLargest(int k, int[] nums) {
//        this.kth = k;
//        this.nums = nums;
//        for(Integer integer:nums){
//            arrayList.add(integer);
//        }
//    }
//    public int add(int val) {
//        arrayList.add(val);
//        Collections.sort(arrayList);
//        return arrayList.get(arrayList.size() - kth);
//    }
    private int kth;
    private PriorityQueue<Integer> queue = null;
    public KthLargest(int k, int[] nums) {
        this.kth = k;
        this.queue = new PriorityQueue(kth);
        for(Integer i : nums){
            add(i);
        }
    }
    public int add(int val) {
        if(this.queue.size() < kth){
            queue.offer(val);
        }
        else if (queue.peek() < val){
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargest k = new KthLargest(3,new int[]{4,5,8,2});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
    }
}
