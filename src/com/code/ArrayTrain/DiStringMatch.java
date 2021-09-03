package com.code.ArrayTrain;

public class DiStringMatch {
    public int[] diStringMatch(String s) {
        int left = 0;
        int right = s.length();
        int[] arr = new int[right + 1];
        for (int i = 0;i < s.length();i ++){
            if (s.charAt(i) == 'I'){
                arr[i] = left ++;
            }
            else{
                arr[i] = right --;
            }
        }
        if (s.charAt(s.length() - 1) == 'I'){
            arr[arr.length - 1] = arr[arr.length - 2] + 1;
        }
        else{
            arr[arr.length - 1] = arr[arr.length - 2] - 1;
        }
        return arr;
    }
}
