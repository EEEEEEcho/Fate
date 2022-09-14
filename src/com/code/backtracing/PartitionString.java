package com.code.backtracing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PartitionString {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrace(s,new ArrayDeque<>(),0);
        return result;
    }

    public void backTrace(String s, Deque<String> path,int start){

        if (start >= s.length()){
            result.add(new ArrayList<>(path));
        }
        else{
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s,start,i)){
                    String substring = s.substring(start, i + 1);
                    path.addLast(substring);
                }
                else {
                    continue;
                }
                backTrace(s, path, i + 1);
                path.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s,int start,int end){
        for (int i = start,j = end; i < j; i++,j --) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PartitionString partitionString = new PartitionString();
        List<List<String>> aab = partitionString.partition("aab");
        System.out.println(aab);
    }
}
