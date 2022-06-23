package com.code.EveryDay;

import java.util.ArrayList;
import java.util.Collections;

public class SmallestDistancePair {
    public int smallestDistancePair(int[] nums, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                arrayList.add(Math.abs(nums[j] - nums[i]));
            }
        }
        Collections.sort(arrayList);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = arrayList.get(i);
        }
        return ans;
    }
}
