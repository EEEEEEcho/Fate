package com.base.basics.knowledge;

//拷贝对象和原始对象的引用类型引用不同对象。
public class DeepCloneExample implements Cloneable{
    private int[] arr;

    public DeepCloneExample(){
        arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
    }

    public void set(int index,int value){
        arr[index] = value;
    }

    public int get(int index){
        return arr[index];
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepCloneExample res = (DeepCloneExample) super.clone();
        res.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res.arr[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        DeepCloneExample d1 = new DeepCloneExample();
        DeepCloneExample d2 = null;
        try {
            d2 = (DeepCloneExample) d1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        d1.set(0,1000);
        System.out.println(d2.get(0));
    }
}
