package com.thinkInJava.chapter14;


import java.util.ArrayList;
import java.util.List;

class CountedInteger{
    private static long counter;
    private final long id = counter ++;
    public String toString(){
        return Long.toString(id);
    }
}
public class FilledList<T> {
    private Class<T> type;  //一个类型信息
    public FilledList(Class<T> type){
        this.type = type;
    }
    public List<T> create(int elements){
        List<T> result = new ArrayList<T>();
        try {
            for(int i = 0;i < elements;i ++){
                result.add(type.newInstance());
            }
        }
        catch (Exception e){
            throw new RuntimeException();
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> filledList = new FilledList<>(CountedInteger.class);
        System.out.println(filledList.create(15));
    }
}
