package com.thinkInJava.chapter14;

class Building{

}
class House extends Building{

}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();   //创建一个父类型的
        Class<House> houseClass = House.class;  //获取子类型的类引用
        House house = houseClass.cast(b);   //强转为子类型
        b = (House) b;
        boolean instance = String.class.isInstance("@@@@@");
        System.out.println(instance);
    }
}
