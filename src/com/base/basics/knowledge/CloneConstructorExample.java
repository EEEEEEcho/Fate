package com.base.basics.knowledge;

public class CloneConstructorExample {
    private int[] arr;

    public CloneConstructorExample(){
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public CloneConstructorExample(CloneConstructorExample original){
        arr = new int[original.arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = original.arr[i];
        }
    }

    public void set(int index,int value){
        arr[index] = value;
    }

    public int get(int index){
        return arr[index];
    }

    public static void main(String[] args) {
        CloneConstructorExample c = new CloneConstructorExample();
        CloneConstructorExample c2 = new CloneConstructorExample(c);
        c.set(0,1000);
        System.out.println(c2.get(0));
    }
}
