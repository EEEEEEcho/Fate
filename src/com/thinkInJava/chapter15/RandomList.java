package com.thinkInJava.chapter15;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random random = new Random(47);
    public void add(T t){
        this.storage.add(t);
    }
    public T select(){
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        for(String s : ("Please watch your step.").split(" ")){
            randomList.add(s);
        }
        for(int i=0;i < 4;i ++){
            System.out.println(randomList.select() + " ");
        }
    }
}
