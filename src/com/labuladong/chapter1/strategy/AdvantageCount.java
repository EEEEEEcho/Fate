package com.labuladong.chapter1.strategy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageCount {
    //我自己的实现思路，应该是正确的，因为本来就跟顺序无关，但是答案要求又跟顺序有关了
    //跟labuladong思路一样，但可能因为顺序问题
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int result[] = new int[nums1.length];
        Arrays.sort(nums1);
        PriorityQueue<Struct> pq = new PriorityQueue<>(nums2.length,
                (s1,s2) -> s2.value - s1.value);
        for (int i = 0; i < nums2.length; i++) {
            pq.add(new Struct(i,nums2[i]));
        }
        int i = 0;
        int j = nums1.length - 1;
        while (!pq.isEmpty()){
            Struct heapTop = pq.poll();
            if (nums1[j] >= heapTop.value){
                result[heapTop.index] = nums1[j --];
            }
            else{
                result[heapTop.index] = nums1[i ++];
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
    class Struct{
        int index;
        int value;
        public Struct(int index,int value){
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        AdvantageCount advantageCount = new AdvantageCount();
        advantageCount.advantageCount(new int[]{2,7,11,15},new int[]{1,10,4,11});
    }
}
