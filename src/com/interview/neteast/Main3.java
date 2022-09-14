package com.interview.neteast;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2,o1));
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            priorityQueue.add(num);
        }
        scanner.nextLine();
        for (int i = 0; i < k; i++) {
            Integer num = priorityQueue.poll();
            num -= x;
            priorityQueue.add(num);
        }
        System.out.println(priorityQueue.peek());
    }
}
