package com.code.Dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DeleteAndEarn {
    //所以，这种DP的题还是要用线性结构来做，字典维护顺序和记录状态上 内力不沾
    public int deleteAndEarn(int[] nums) {
        //这样不行
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        if (map.size() == 1){
            return map.firstKey() * map.get(map.firstKey());
        }
        else if(map.size() == 2){
            if(Math.abs(map.firstKey() - map.lastKey()) == 1){
                return Math.max(map.firstKey() * map.get(map.firstKey()),map.lastKey() * map.get(map.lastKey()));
            }
            return map.firstKey() * map.get(map.firstKey()) + map.lastKey() * map.get(map.lastKey());
        }
        else{
            int x = map.firstKey() * map.get(map.firstKey());
            map.remove(map.firstKey());
            int y = Math.max(x,map.firstKey() * map.get(map.firstKey()));
            map.remove(map.firstKey());
            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                int tmp = y;
                int m = x + entry.getKey() * entry.getValue();
                if (m > y){
                    y = m;
                    if (map.get(entry.getKey() + 1) != null){
                        map.remove(entry.getKey() + 1);
                    }
                    if (map.get(entry.getKey() - 1) != null){
                        map.remove(entry.getKey() - 1);
                    }
                }
                x = tmp;
            }
            return y;
        }
    }
    public int deleteAndEarn1(int[] nums){
        int len = Arrays.stream(nums).max().getAsInt();
        int[] sum = new int[len + 1];
        for (int n : nums){
            sum[n] += n;
        }
        int x = sum[0];
        int y = Math.max(sum[0],sum[1]);
        for (int i = 2; i < sum.length; i++) {
            int tmp = y;
            y = Math.max(x + sum[i],y);
            x = tmp;
        }
        return y;
    }

    public static void main(String[] args) {
        String s = new String("Hello world");
        String j = s.replaceAll("H","M");
        System.out.println(s);
        System.out.println(j);
    }
}
