package com.labuladong.chapter1.datastructdesign;

import java.util.*;

public class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a,b) -> {
            return b - a;
        });
    }

    public void addNum(int num) {
        if (small.size() >= large.size()){
            small.offer(num);
            large.offer(small.poll());
        }
        else{
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()){
            return small.peek();
        }
        else if (large.size() > small.size()){
            return large.peek();
        }
        return (double) (large.peek() + small.peek()) / 2;
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
    }
}
