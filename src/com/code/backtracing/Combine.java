package com.code.backtracing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        int[] mark = new int[n + 1];
        List<List<Integer>> ans = new ArrayList<>();
        doCombine(mark,1,n,new ArrayDeque<>(),k,ans);
        return ans;
    }
    public void doCombine(int[] mark, int start, int end, Deque<Integer> path,int length,List<List<Integer>> ans){
        if(path.size() == length){
            ans.add(new ArrayList<>(path));
        }
        else{
            for (int i = start; i <= end ; i++) {
                if (mark[i] == 0){
                    path.add(i);
                    doCombine(mark,i + 1,end,path,length,ans);
                    mark[i] = 0;
                    path.removeLast();
                }
            }
        }
    }
}
