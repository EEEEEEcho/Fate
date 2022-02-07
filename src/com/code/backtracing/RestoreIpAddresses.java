package com.code.backtracing;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    private final List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() <= 12){
            dfs(s,0,0);
        }
        return result;
    }

    /*
     * @param s 要分割的字符串
     * @param startIndex 开始分割的位置
     * @param pointNum 已经分割的字符串中 . 的数量
     */
    public void dfs(String s,int startIndex,int pointNum){
        if (pointNum == 3){
            if (isValid(s,startIndex,s.length() - 1)){
                result.add(s);
            }
            return;
        }
        else{
            for (int i = startIndex; i < s.length(); i++) {
                if (isValid(s,startIndex,i)){
                    //这道题并没有中间结果，而是直接在原来的字符串上进行操作
                    s = s.substring(0,i + 1) + "." + s.substring(i + 1);
                    pointNum ++;
                    dfs(s,i + 2,pointNum);
                    //回溯
                    pointNum --;
                    s = s.substring(0,i + 1) + s.substring(i + 2);
                }
                else {
                    break;
                }
            }
        }
    }

    public boolean isValid(String s,int start,int end){
        if (start > end){
            return false;
        }
        if(s.charAt(start) == '0' && start != end){
            return false;
        }
        int num = 0;
        for (int i = start; i <=end ; i++) {
            //非数字字符非法
            if (s.charAt(i) > '9' || s.charAt(i) < '0'){
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RestoreIpAddresses r = new RestoreIpAddresses();
        List<String> strings = r.restoreIpAddresses("25525511135");
        System.out.println(strings);
    }
}
