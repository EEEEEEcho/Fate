package com.thinkInJava.chapter15;

public class GenericArray2<T> {
    private Object[] array;
    public GenericArray2(int size){
        array = new Object[size];
    }
    public void put(int index,T item){
        array[index] = item;
    }
    public T get(int index){
        return (T)array[index];
    }
    public T[] rep(){
        return (T[]) array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gia2 = new GenericArray2<>(10);
        for(int i=0;i < 10;i ++){
            gia2.put(i,i);
        }
        for (int i=0; i < 10;i ++){
            System.out.print(gia2.get(i) + " ");
        }
        System.out.println();
        try {
            Integer[] ia = gia2.rep();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
