package com.leetCode.StringTrain;

public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        String result = "";
        for(int i = 0 ;i < k;i ++){
            result += s1[i] + " ";
        }
        return result.trim();
    }
}
