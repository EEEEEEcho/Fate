package com.genericlearn.demo05;

/**
 * 泛型接口的实现类是一个泛型类，那么要保证实现接口的实现类泛型标识要包含泛型接口的泛型标识
 * @param <T>
 * @param <E>
 */
public class Orangle<T,E> implements Geneator<T>{
    private T key;
    private E value;
    public Orangle(T key,E value){
        this.key = key;
        this.value = value;
    }
    @Override
    public T getKey() {
        return key;
    }
    public E getValue(){
        return value;
    }
}
