package com.code.EveryDay;

public class DiStringMatch {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        int max = n;
        int min = 0;
        //确定ans[0]的值，
        //如果s[0] = ‘I’ 那么ans[0]的值为min，即0，可以满足所有ans[1] > ans[0]
        //如果s[0] = ‘D’ 那么ans[0]的值为max，即n，可以满足所有ans[1] < ans[0]
        //确定好ans[0]的值后，剩余问题和原问题一样，变成了规模为n - 1的问题
        //依然采用上述策略进行选取
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'I'){
                ans[i] = min ++;
            }
            else{
                ans[i] = max --;
            }
        }
        //最后剩下一个数，此时max = min,填哪个都行
        ans[n] = min;
        return ans;
    }
}
