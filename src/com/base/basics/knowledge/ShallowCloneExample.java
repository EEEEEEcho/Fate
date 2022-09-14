package com.base.basics.knowledge;

/**
 * 浅拷贝中，拷贝对象和原始对象的引用类型引用同一个对象
 */
public class ShallowCloneExample implements Cloneable{
    private int[] arr;

    public ShallowCloneExample(){
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

    //浅拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }

    public static void main(String[] args) {
        ShallowCloneExample e1 = new ShallowCloneExample();
        ShallowCloneExample e2 = null;
        try {
            e2 = (ShallowCloneExample) e1.clone();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        e1.set(0,1000);
        System.out.println(e2.get(0));
    }
}
