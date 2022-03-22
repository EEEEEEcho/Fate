package com.code.EveryDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hashMap.put(list1[i],i);
        }
        HashMap<String,Integer> res = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (hashMap.containsKey(list2[i])){
                int sum = i + hashMap.get(list2[i]);
                min = Math.min(sum,min);
                res.put(list2[i], sum);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String,Integer> entry : res.entrySet()){
            if (entry.getValue() == min){
                list.add(entry.getKey());
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public String[] findRestaurant2(String[] list1, String[] list2) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hashMap.put(list1[i],i);
        }
        List<String> list = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (hashMap.containsKey(list2[i])){
                int index = hashMap.get(list2[i]) + i;
                if (index < minIndex){
                    list.clear();
                    list.add(list2[i]);
                    minIndex = index;
                }
                else if (index == minIndex){
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}
