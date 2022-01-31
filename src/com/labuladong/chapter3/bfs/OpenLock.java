package com.labuladong.chapter3.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenLock {

    public int openLock(String[] deadends, String target) {
        HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                String str = queue.poll();
                if (deadSet.contains(str)){
                    size --;
                    continue;
                }
                if (target.equals(str)) return step;
                for (int i = 0; i < 4; i++) {
                    String upLock = upLock(str, i);
                    if (!visited.contains(upLock)){
                        visited.add(upLock);
                        queue.offer(upLock);
                    }
                    String downLock = downLock(str, i);
                    if (!visited.contains(downLock)){
                        visited.add(downLock);
                        queue.offer(downLock);
                    }
                }
                size --;
            }
            step ++;
        }
        return -1;
    }

    private String upLock(String str,int i){
        char[] chars = str.toCharArray();
        if (chars[i] == '9'){
            chars[i] = '0';
        }
        else{
            chars[i] ++;
        }
        return new String(chars);
    }

    private String downLock(String str,int i){
        char[] chars = str.toCharArray();
        if (chars[i] == '0'){
            chars[i] = '9';
        }
        else{
            chars[i] --;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        OpenLock openLock = new OpenLock();
        openLock.openLock(new String[]{"0000"},"8888");
    }
}
