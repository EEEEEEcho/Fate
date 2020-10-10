package com.thinkInJava.chapter15;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee>{
    private Class[] types = {
            Latte.class,Mocha.class,Cappuccino.class,Americano.class,Breve.class
    };
    private static Random random = new Random(47);
    public CoffeeGenerator(){

    }
    private int size = 0;
    public CoffeeGenerator(int size){
        this.size = size;
    }
    @Override
    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].newInstance();
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }
    class CoffeeIterator implements Iterator<Coffee>{
        int count = size;
        public boolean hasNext(){
            return count > 0;
        }
        public Coffee next(){
            count --;
            //调用外部类的next方法
            return CoffeeGenerator.this.next();
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for(int i=0;i < 5;i ++){
            System.out.println(gen.next());
        }
        for(Coffee c : new CoffeeGenerator(5)){
            System.out.println(c);
        }
    }
}
