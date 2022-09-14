package com.code.EveryDay;

public class MinDeletionSize {
    public int minDeletionSize(String[] strs) {
        if (strs.length == 1) return 0;
        int n = strs.length;
        int m = strs[0].length();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (strs[j + 1].charAt(i) < strs[j].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
