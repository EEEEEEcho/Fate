package com.code.backtracing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RestoreIpAddresses {
    private List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s,0,new ArrayDeque<>());
        return result;
    }
    public void dfs(String s, int start, Deque<String> deque){
        if (start == s.length() && deque.size() == 4){
            result.add(String.join(".",deque));
        }
        else{
            for (int i = start; i < s.length(); i++) {
                if(i - start > 3){
                    break;
                }
                if(isRight(s,start,i)){
                    deque.add(s.substring(start,1));
                    dfs(s,i + 1,deque);
                    deque.removeLast();
                }
            }
        }
    }
    private boolean isRight(String s,int start,int end){
        if (start == end){
            return false;
        }
        int i = Integer.parseInt(s.substring(start, end));
        return (i >=1 && i <= 255);
    }

    public static void main(String[] args) {
        RestoreIpAddresses r = new RestoreIpAddresses();
        r.restoreIpAddresses("25525511135");
    }
}
