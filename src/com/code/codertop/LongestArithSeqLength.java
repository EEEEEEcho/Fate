package com.code.codertop;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LongestArithSeqLength {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        //{当前下标:{公差:当前下标该公差最长的等差数列}}
        int max = 0;
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,new HashMap<>());
            for (int j = i - 1; j >= 0; j--) {
                if (map.get(i).containsKey(nums[i] - nums[j])) continue;
                //看看有没有以j结尾，且公差为num[i]-nums[j]的
                int cur = map.get(j).getOrDefault(nums[i] - nums[j],0);
                max = Math.max(max,cur + 2);
                map.get(i).put(nums[i] - nums[j],cur + 1);
            }
        }
        return max;
    }

    public static void main(String[] args){
        CountDownLatch ct = new CountDownLatch(2);
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ct.countDown();
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                ct.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            ct.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("OK");
    }
}