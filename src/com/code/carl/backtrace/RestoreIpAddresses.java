package com.code.carl.backtrace;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RestoreIpAddresses {
    List<List<String>> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTrace(s,new ArrayDeque<>(),0,1);
        List<String> ans = new ArrayList<>();
        for (List<String> list : result){
            ans.add(String.join(".",list));
        }
        return ans;
    }

    public void backTrace(String s, Deque<String> path,int start,int pointNum){
        if (pointNum == 4){
            if (isValid(s.substring(start))){
                path.addLast(s.substring(start));
                result.add(new ArrayList<>(path));
                //这里不移除的话，在递归返回之后就没办法移除最后一个元素
                path.removeLast();
            }
        }
        else {
            for (int i = start; i < s.length(); i++) {
                String subStr = s.substring(start,i + 1);
                if (isValid(subStr)){
                    path.addLast(subStr);
                    pointNum ++;
                }
                else{
                    continue;
                }
                backTrace(s,path,i + 1,pointNum);
                path.removeLast();
                pointNum --;
            }
        }
    }

    public boolean isValid(String subStr){
        if (subStr == null || subStr.length() == 0) return false;
        if (subStr.length() > 1 && subStr.startsWith("0")) return false;
        long ipNum = Long.parseLong(subStr);
        return ipNum >= 0 && ipNum <= 255;
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> list = restoreIpAddresses.restoreIpAddresses("25525511135");
        System.out.println(list);
    }
}
