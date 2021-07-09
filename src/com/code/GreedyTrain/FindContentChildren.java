package com.code.GreedyTrain;

import java.util.Arrays;

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        for(int i = g.length - 1,j = s.length - 1;i >= 0 ;i--){
            if(j < 0){
                break;
            }
            if(s[j] >= g[i]){
                result++;
                j --;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindContentChildren f = new FindContentChildren();
        System.out.println(f.findContentChildren(new int[]{1,2},new int[]{1,2,3}));
    }
}
