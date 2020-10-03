package com.thinkInJava.chapter11;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAll(Arrays.asList("cao","ni","ma"));
        System.out.println(linkedList);
        System.out.println("linkedList getFirst(): " + linkedList.getFirst());
        System.out.println("linkedList.element() : " + linkedList.element());
        System.out.println("linkedList.peek() : " + linkedList.peek());
        System.out.println("linkedList.remove() :" + linkedList.remove());
        System.out.println("linkedList.removeFirst() :" + linkedList.removeFirst());
        System.out.println("linkedList.poll() :" + linkedList.poll());
        System.out.println(linkedList);
        linkedList.add("Hello");
        System.out.println("linkedList after add() :" + linkedList);
        linkedList.offer("World");
        System.out.println("linkedList after offer() :" + linkedList);
        linkedList.addFirst("Don't");
        System.out.println("linkedList after addFirst() :" + linkedList);
        linkedList.addLast("Touch");
        System.out.println("linkedList after addLast() :" + linkedList);
        System.out.println("linkedList after removeLast() :" + linkedList.removeLast());
    }
}
