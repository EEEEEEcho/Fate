package com.code.EveryDay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinMutation {
    //广搜
    public int minMutation(String start, String end, String[] bank) {

        HashSet<String> visited = new HashSet<>();
        HashSet<String> setBank = new HashSet<>(Arrays.asList(bank));

        char[] keys = {'A','G','C','T'};

        if (start.equals(end)){
            return 0;
        }

        if (!setBank.contains(end)){
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int count = 1;
        while (!queue.isEmpty()){
            int sz = queue.size();
            //遍历由当前字符串能够改变一个字符延伸出去的所有字符串
            for (int index = 0; index < sz; index++) {
                String str = queue.poll();
                //对当前字符串每个位置都尝试变换一下AGCT
                for (int i = 0; i < str.length(); i++) {
                    for (int j = 0; j < 4; j++) {
                        if (str.charAt(i) != keys[j]){
                            StringBuilder sb = new StringBuilder(str);
                            sb.setCharAt(i,keys[j]);
                            String next = sb.toString();
                            //如果变换后的字符串在基因库里且之前没有遍历到过该串
                            if (!visited.contains(next) && setBank.contains(next)){
                                if (next.equals(end)){
                                    return count;
                                }
                                //添加到下一层中
                                visited.add(next);
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
            count ++;
        }
        return -1;
    }
    public static void main(String[] args) {
        MinMutation minMutation = new MinMutation();
        int i = minMutation.minMutation(
                "AAAACCCC", "CCCCCCCC", new String[]{"AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC"});
        System.out.println(i);

    }
}
