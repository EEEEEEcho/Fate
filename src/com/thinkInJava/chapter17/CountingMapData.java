package com.thinkInJava.chapter17;

import java.util.*;

public class CountingMapData extends AbstractMap<Integer,String> {
    private int size;
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    public CountingMapData(int size){
        this.size = Math.max(size,0);
    }

    /**
     * 重写Entry的定义
     */
    private static class Entry implements Map.Entry<Integer,String>{
        int index;

        Entry(int index){
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
    }


    /**
     * 重写EntrySet的定义
     * @return
     */
    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            //这里每new 一个Entry对象，就会给其指定一个index，在使用该Entry对象getValue时，会
            //根据我们自定义的规则，取出我们定义的值
            entries.add(new Entry(i));
        }
        return entries;
    }

    public static void main(String[] args) {
        System.out.println(new CountingMapData(160));
    }
}
