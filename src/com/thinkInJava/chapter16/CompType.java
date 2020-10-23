package com.thinkInJava.chapter16;

import com.thinkInJava.chapter15.Generator;

import java.util.Random;

public class CompType implements Comparable<CompType>{
    int i;
    int j;
    private static int count = 1;
    public CompType(int i,int j){
        this.i = i;
        this.j = j;
    }
    @Override
    public int compareTo(CompType o) {
        return Integer.compare(i, o.i);
    }

    @Override
    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if(count ++ % 3 == 0){
            result += "\n";
        }
        return result;
    }

    private static Random random = new Random(47);
    public static Generator<CompType> generator(){
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(random.nextInt(100), random.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        //CompType[] a =
    }
}
