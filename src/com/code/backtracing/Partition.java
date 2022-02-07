package com.code.backtracing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Partition {
    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int[][] mark = new int[s.length()][s.length()];
        dfsMemory(s,new ArrayDeque<>(),0,mark);
        return result;
    }
    //题解：https://leetcode-cn.com/problems/palindrome-partitioning/solution/shou-hua-tu-jie-san-chong-jie-fa-hui-su-q5zjt/
    //非记忆化搜索版
    //每次递归都调用isPali判断，是否有必要？以“aab”为例，我们打印一下传入 isPali 的 start 和 i：
    //0 0
    //1 1
    //2 2
    //1 2
    //0 1
    //2 2 （重复）
    //0 2
    public void dfs(String s, Deque<String> tmp, int start){
        if (start == s.length()){
            result.add(new ArrayList<>(tmp));
        }
        else{
            for (int i = start; i < s.length(); i++) {
                if(isRight(s,start,i)){
                    tmp.add(s.substring(start,i + 1));
                    dfs(s,tmp,i + 1);
                    tmp.removeLast();
                }
            }
        }
    }

    /**
     * 判断字符串s，从start到end是否为回文串
     * @param s
     * @param start
     * @param end
     * @return
     */
    public boolean isRight(String s,int start,int end){
        while (start <= end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }

    //记忆化搜索，创建一个二维数组，将已经判断过回文的记录下来
    public void dfsMemory(String s, Deque<String> tmp, int start,int[][] mark){
        if (start == s.length()){
            result.add(new ArrayList<>(tmp));
        }
        else{
            for (int i = start; i < s.length(); i++) {
                if (mark[start][i] == 1) continue;  //不回文
                if(mark[start][i] == 2 || isRightMemory(s,start,i,mark)){   //已经检测过是回文串，或者还没有检测过
                    tmp.add(s.substring(start,i + 1));
                    dfsMemory(s,tmp,i + 1,mark);
                    tmp.removeLast();
                }
            }
        }
    }



    public boolean isRightMemory(String s,int start,int end,int[][] mark){
        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                mark[start][end] = 1;   //不回文
                return false;
            }
            start ++;
            end --;
        }
        mark[start][end] = 2;   //回文
        return true;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        boolean aba = partition.isRight("aba", 0, 1);
        System.out.println(aba);
    }
}
