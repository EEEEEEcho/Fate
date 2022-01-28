package com.underlying;

import java.util.HashMap;
import java.util.Objects;

public class HashMapUnderlying2 {
    /**
     * 树化
     * @param args
     */
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
//        for (int i = 1; i <= 12; i++) {
//            hashMap.put(new Item(i),"Hello world");
//        }
//        System.out.println(hashMap);
        for (int i = 0; i < 78; i++) {
            hashMap.put(i,"HELLO");
        }
        hashMap.get(1);
        System.out.println(hashMap);
    }
}
class Item{
    private int num;
    public Item(int num){
        this.num = num;
    }

    /**
     * 所有对象的hashcode都是100
     * @return
     */
    @Override
    public int hashCode() {
        return 100;
    }
}