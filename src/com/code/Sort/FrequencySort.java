package com.code.Sort;

import java.util.*;

public class FrequencySort {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(Integer integer : nums){
            map.merge(integer, 1, Integer::sum);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int tmp = o1.getValue() - o2.getValue();
                if(tmp == 0){
                    return - (o1.getKey() - o2.getKey());
                }
                return tmp;
            }
        });
//        for(Map.Entry<Integer,Integer> entry : list){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        int i = 0;
        int[] results = new int[nums.length];
        for (Map.Entry<Integer,Integer> entry : list){
            //System.out.println(entry.getKey());
            int frequency = entry.getValue();
            int key = entry.getKey();
            while (frequency > 0){
                results[i ++] = key;
                frequency --;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        int result[] = frequencySort.frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1});
        for(Integer integer : result){
            System.out.print(integer + " ");
        }
    }
}
