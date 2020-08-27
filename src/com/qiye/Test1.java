package com.qiye;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Test1 extends Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
//        list.remove("a");
//        System.out.println(list);
//        for(Object obj:list){
//            list.remove(obj);
//        }
//        System.out.println(list);
        for(Iterator it = list.iterator();it.hasNext();){
            it.next();
            it.remove();
        }
        System.out.println(list);
    }
}
