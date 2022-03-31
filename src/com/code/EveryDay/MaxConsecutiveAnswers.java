package com.code.EveryDay;

public class MaxConsecutiveAnswers {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getMax(answerKey,k,'T'),getMax(answerKey,k,'F'));
    }
    private int getMax(String answerKey,int k,char chr){
        int right = 0;
        int left = 0;
        int ftimes = 0;
        int count = 0;
        while (right < answerKey.length()){
            char c = answerKey.charAt(right);
            if (c == chr){
                ftimes ++;
            }
            right ++;
            while (ftimes > k){
                char t = answerKey.charAt(left);
                if (t == chr){
                    ftimes --;
                }
                left ++;
            }
            count = Math.max(count,right - left);
        }
        return count;
    }
}
