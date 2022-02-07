package com.thinkInJava.chapter11;

import java.util.*;

public class MultiIterableClass extends IterableClass{

    public Iterable<String> reversed(){
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int current = words.length - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public String next() {
                        return words[current --];
                    }
                };
            }
        };
    }

    public Iterable<String> random(){
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<>(Arrays.asList(words));
                Collections.shuffle(shuffled);
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass multiIterableClass = new MultiIterableClass();
        for(String s : multiIterableClass){
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : multiIterableClass.reversed()){
            System.out.print(s + " ");
        }
        System.out.println();
        for(String s : multiIterableClass.random()){
            System.out.print(s + " ");
        }
    }
}
