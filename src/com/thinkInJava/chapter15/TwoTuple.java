package com.thinkInJava.chapter15;

public class TwoTuple<A,B> {
    public final A first;
    public final B second;
    public TwoTuple(A a,B b){
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
