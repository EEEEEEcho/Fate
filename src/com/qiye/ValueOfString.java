package com.qiye;

import java.util.*;

public class ValueOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        char array[] = s.toCharArray();
        /**
         * 使用HashMap字典来统计每个字符出现的次数
         */
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i=0;i < array.length;i ++){
            if(hashMap.containsKey(array[i])){
                int weight = hashMap.get(array[i]);
                hashMap.put(array[i],weight + 1);
            }
            else{
                hashMap.put(array[i],1);
            }
        }
        /**
         * 构建一个数组，保存每个字符出现的次数
         */
        int sum[] = new int[hashMap.size()];
        int index = 0;
        for(Map.Entry entry:hashMap.entrySet()){
            sum[index] = (Integer)entry.getValue();
            index ++;
        }
//        for(int i=0;i < sum.length;i ++){
//            System.out.println(sum[i]);
//        }
        /**
         * 每次都对统计数组排序，让最大值减一
         */
        while(n > 0){
            Arrays.sort(sum);
            sum[sum.length -1] --;
            n--;
        }
        /**
         * 对操作完成的数组中每一个值求和
         */
        int result = 0;
        for(int i=0;i < sum.length;i ++){
            result += sum[i] * sum[i];
        }
        System.out.println(result);
    }
}
