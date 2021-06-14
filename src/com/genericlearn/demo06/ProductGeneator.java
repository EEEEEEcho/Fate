package com.genericlearn.demo06;

import java.util.ArrayList;
import java.util.Random;

public class ProductGeneator<T> {
    private T product;
    private ArrayList<T> arrayList = new ArrayList<>();
    private Random random = new Random();


    public void addProduct(T product){
        this.arrayList.add(product);
    }

    /**
     * 这是泛型类里面定义的方法，但并不是泛型方法
     * @return
     */
    //使用了泛型类中定义的类型的类中方法不可以由 static 修饰
    public T chooseProduct(){
        return arrayList.get(random.nextInt(this.arrayList.size()));
    }

    /**
     * 这是泛型方法
     * 泛型方法是在调用方法的时候指明泛型的具体类型。
     * 修饰符 <T，E, ...> 返回值类型 方法名(形参列表) { 方法体... }
     * public与返回值中间非常重要，可以理解为声明此方法为泛型方法。
     * 只有声明了的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * < T >表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * 与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     * 泛型方法可以独立于泛型类
     * @param arrayList 参数
     * @param <E> 泛型标识，具体类型由调用者指定
     * @return
     */

    public <E> E chooseProduct2(ArrayList<E> arrayList){
        return arrayList.get(random.nextInt(arrayList.size()));
    }

    //泛型方法可以由static修饰,而类中定义的使用了泛型类中声明的参数类型的方法 不可以由static修饰
    public static <T,E,K> void printType(T t,E e,K k){
        System.out.println(t + "\t" + t.getClass());
        System.out.println(e + "\t" + e.getClass());
        System.out.println(k + "\t" + k.getClass());
    }

    //泛型方法与可变参数列表
    public static <E> void printfVariable(E ... e){
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i] + "\t" + e[i].getClass());
        }
    }
}
