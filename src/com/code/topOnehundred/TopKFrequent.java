package com.code.topOnehundred;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TopKFrequent {
    public int[] topKFrequent1(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>((key1,key2) -> key2 - key1);
        int[] res = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])){
                continue;
            }
            else{
                int target = nums[i];
                hashSet.add(nums[i]);
                int left = 0;
                int right = nums.length - 1;
                while (left <= right){
                    int mid = left + (right - left) / 2;
                    if (target == nums[mid]){
                        right = mid - 1;
                    }
                    else if (target > nums[mid]){
                        left = mid + 1;
                    }
                    else {
                        right = mid - 1;
                    }
                }
                if (left >= 0 && nums[left] == target){
                    int count = 0;
                    while (left < nums.length && nums[left] == target){
                        count ++;
                        left ++;
                    }
                    treeMap.put(count,target);
                }
            }
        }
        System.out.println(treeMap);
        Iterator<Map.Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator();
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            res[i] = entry.getValue();
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((entry1,entry2) -> entry2.getValue() - entry1.getValue());
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        pq.addAll(map.entrySet());
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(pq.poll()).getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequent t = new TopKFrequent();
        int[] ints = t.topKFrequent(new int[]{1, 2}, 2);
        System.out.println(Arrays.toString(ints));
    }
}
