package com.thinkInJava.chapter11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
    public static void printQ(Queue queue){
        while (queue.peek() != null){
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random(47);
        for(int i=0;i < 10; i++){
            queue.offer(random.nextInt(i + 10));
        }
        System.out.println(queue);
        Queue<Character> qc = new LinkedList<Character>();

        for(char c : "BROUNTDASW".toCharArray()){
            qc.offer(c);
        }
        System.out.println(qc);
    }
}
