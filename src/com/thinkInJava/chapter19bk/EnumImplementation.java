package com.thinkInJava.chapter19bk;

import com.genericlearn.demo05.Geneator;
import com.thinkInJava.chapter15.Generator;

import java.util.Random;

enum CartoonCharacter implements Generator<CartoonCharacter>{
    SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
    private Random random = new Random();
    @Override
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}
public class EnumImplementation {
    public static <T> void printNext(Generator<T> geneator){
        System.out.print(geneator.next() + " ,");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}
