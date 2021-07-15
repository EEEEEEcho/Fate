package com.code.ArrayTrain;

import java.util.*;

public class FindLHS {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> hashMap = new LinkedHashMap<>();
        for (int num : nums){
            hashMap.put(num,hashMap.get(num) == null ? 1 : hashMap.get(num) + 1);
        }
        int max = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        Map.Entry<Integer, Integer> pre = iterator.next();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getKey() - pre.getKey() == 1){
                max = Math.max(next.getValue() + pre.getValue(),max);
            }
            pre = next;
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Iterator<Integer> iterator = li.iterator();
        while (iterator.hasNext()){
            System.out.printf("%d ", iterator.next());
        }
    }
}
