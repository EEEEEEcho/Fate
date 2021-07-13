package com.thinkInJava.chapter17;

import java.util.LinkedList;

public class Deque <T>{
    private LinkedList<T> dequeue = new LinkedList<>();

    public void addFirst(T e){
        dequeue.addFirst(e);
    }

    public void addLast(T e){
        dequeue.addLast(e);
    }

    public T getFirst(){
        return dequeue.getFirst();
    }

    public T getLast(){
        return dequeue.getLast();
    }

    public T removeFirst(){
        return dequeue.removeFirst();
    }

    public T removeLast(){
        return dequeue.removeLast();
    }

    public int size(){
        return dequeue.size();
    }

    @Override
    public String toString() {
        return "Deque{" +
                "dequeue=" + dequeue +
                '}';
    }
}
