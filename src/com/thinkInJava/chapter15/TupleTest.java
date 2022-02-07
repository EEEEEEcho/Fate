package com.thinkInJava.chapter15;
class Amphibian{

}
class Vehicle{

}
public class TupleTest {
    static TwoTuple<String,Integer> f(){
        return new TwoTuple<>("hi",47);
    }
    static ThreeTuple<Amphibian,String,Integer> g(){
        return new ThreeTuple<>(new Amphibian(),"cnd",48);
    }

    public static void main(String[] args) {
        TwoTuple twoTuple = f();
        ThreeTuple threeTuple = g();
        System.out.println(twoTuple);
        System.out.println(threeTuple);
    }
}
