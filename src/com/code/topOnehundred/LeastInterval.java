package com.code.topOnehundred;

import com.code.link.ListNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0){
            return tasks.length;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : tasks){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        int count = 0;
        int interval = 0;
        while (map.size() > 0){
            interval = map.size() > n ? 0 : n - map.size() + 1;
            Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Character, Integer> entry = iterator.next();
                Integer value = entry.getValue();
                value -= 1;
                if (value == 0){
                    iterator.remove();
                }
                else{
                    map.put(entry.getKey(),value);
                }
                count ++;
            }
            count += interval;
        }
        return count - interval;
    }

    public ListNode reverse(ListNode head){
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        LeastInterval l = new LeastInterval();
        int i = l.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2);
//        int i = l.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        System.out.println(i);
    }
}
