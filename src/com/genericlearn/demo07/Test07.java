package com.genericlearn.demo07;

import java.util.ArrayList;
import java.util.List;

public class Test07 {
    /**
     * 类型通配符一般是使用"?"代替具体的类型实参。
     * 所以，类型通配符是类型实参，而不是类型形参。
     */
    public static void main(String[] args) {
        Box<Number> box1 = new Box<>();
        box1.setFirst(100);
        showBox(box1);

        Box<Integer> box2 = new Box<>();
        box2.setFirst(200);
        //showBox(box2);报错
        //虽然Integer是Number类型的子类，但是定义的方法中只要求传递Number类型
        //传递子类也不可以，所以泛型中传递的类型参数是无法实现多态的
        System.out.println("--------------------------------");
        showBox2(box1);
        showBox2(box2);
        System.out.println("--------------------------------");
        showBox3(box1);
        showBox3(box2);
        System.out.println("--------------------------------");
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<MiniCat> miniCats = new ArrayList<>();
        //showAnimal(animals); 报错,因为它不符合泛型通配符中定义的类型的上限
        showAnimal(cats);
        showAnimal(miniCats);
        //cats.addAll(animals);
        cats.addAll(miniCats);
        System.out.println("--------------------------------");
        showAnimal2(animals);
        showAnimal2(cats);
        //showAnimal2(miniCats); 报错,因为不符合泛型通配符中定义的类型的下限,下限最低是Cat
    }

    //为了解决传递的类型参数 是不确定的 的问题，使用类型通配符来解决
    public static void showBox(Box<Number> box){
        Number first = box.getFirst();
        System.out.println(first);
    }

    //为了解决传递的类型参数 是不确定的 的问题，使用类型通配符 ? 来解决

    /**
     *      * 类型通配符一般是使用"?"代替具体的类型实参。
     *      * 所以，类型通配符是类型实参，而不是类型形参。
     * @param box
     */
    public static void showBox2(Box<?> box){
        Object first = box.getFirst();  //是object类型的
        System.out.println(first);
    }

    /**
     * 类型通配符的上限
     * 类/接口<? extends 实参类型>
     * 要求该泛型的类型，只能是实参类型，或实参类型的子类类型。
     * 本例中就是,类型参数只能传Number类型以及Number类型的子类型
     * @param box
     */
    public static void showBox3(Box<? extends Number> box){
        Number first = box.getFirst();
        System.out.println(first);
    }

    /**
     * 传入的集合中,其类型只能是Cat以及Cat的子类型
     * @param list
     */
    public static void showAnimal(ArrayList<? extends Cat> list){
        for (int i = 0; i < list.size(); i++) {
            Cat cat = list.get(i);
            System.out.println(cat);
        }

        //list.add(new Cat());报错
        //list.add(new MiniCat());报错
        //使用了上限通配符的集合中是无法添加元素的,因为编译器并不知到你具体要添加的是什么元素
    }

    /**
     * 类型通配符的下限
     * 类/接口<? super 实参类型>
     * 要求该泛型的类型，只能是实参类型，或实参类型的父类类型。
     * 本例中的就是传入的集合中,其类型只能是Cat或者Cat的父类型
     */
    public static void showAnimal2(List<? super Cat> list){
        list.add(new Cat());
        list.add(new MiniCat());
        //下限通配符是可以添加元素的,但是并不会保证元素类型的正确
        for (Object o : list){
            System.out.println(o);
        }
    }
}
