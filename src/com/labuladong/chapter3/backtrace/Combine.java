package com.labuladong.chapter3.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrace(n,new LinkedList<>(),k,1);
        return list;
    }
    public void backtrace(int n, LinkedList<Integer> path,int k,int index){
        if (path.size() == k){
            list.add(new ArrayList<>(path));
            return;
        }
        else{
            for (int i = index; i <= n; i++) {
                path.add(i);
                backtrace(n,path,k,i + 1);
                path.removeLast();
            }
        }
    }
}
