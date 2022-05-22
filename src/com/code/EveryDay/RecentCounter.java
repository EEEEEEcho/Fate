package com.code.EveryDay;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class RecentCounter {
    Deque<Integer> deque = new ArrayDeque<>();
    public RecentCounter() {

    }

    public int ping(int t) {
        deque.offer(t);
        while (deque.peek() < t - 3000){
            deque.poll();
        }
        return deque.size();
    }
}
