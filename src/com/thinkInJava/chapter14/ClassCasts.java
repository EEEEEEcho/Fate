package com.thinkInJava.chapter14;

class Building{

}
class House extends Building{

}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseClass = House.class;
        House house = houseClass.cast(b);
        b = (House) b;
    }
}
