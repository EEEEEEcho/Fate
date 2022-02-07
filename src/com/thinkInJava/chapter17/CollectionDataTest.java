package com.thinkInJava.chapter17;

import com.thinkInJava.chapter15.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

class Gonvernment implements Generator<String>{
    String[] foundation = ("stange women lying in ponds " +
            "distributing swords is no basis for a system of " + "gonverment").split(" ");
    private int index;
    @Override
    public String next() {
        return foundation[index ++];
    }
}
public class CollectionDataTest {

    public static void main(String[] args) {
        //

        Set<String> set = new LinkedHashSet<String>(
                new CollectionData<>(new Gonvernment(),15)
        );
        set.addAll(CollectionData.list(new Gonvernment(),15));
        System.out.println(set);
    }

}
