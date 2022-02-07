package com.code.GreedyTrain;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        int count = 0;
        for(int i=0;i < t.length();i ++){
            if(count >= s.length()){
                break;
            }
            if(s.charAt(count) == t.charAt(i)){
                count++;
            }
        }
        return count == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
    }
}
