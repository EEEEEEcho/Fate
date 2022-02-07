package com.genericlearn.demo10;

import java.lang.reflect.Array;

public class Fruit <T>{
    //private T[] array = new T[3]; 必然报错，因为都不知道T是什么类型
    private  T[] array;
    public Fruit(Class<T> tClass,int length){
        //通过Array.newInstance创建泛型数组
        array = (T[]) Array.newInstance(tClass,length);
    }
    public void put(int index,T item){
        array[index] = item;
    }
    public T get(int index){
        //获取数组元素
        return array[index];
    }

    public T[] getArray(){
        return array;
    }
}
