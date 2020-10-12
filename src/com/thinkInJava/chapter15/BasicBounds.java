package com.thinkInJava.chapter15;
interface HasColor{
    java.awt.Color getColor();
}

class Colored<T extends HasColor>{
    T item;
    Colored(T item){
        this.item = item;
    }
    T getItem(){
        return item;
    }
    java.awt.Color color(){
        return item.getColor();
    }
}

class Dimension{
    public int x,y,z;
}
class ColoredDimension<T extends Dimension & HasColor>{
    T item;
    ColoredDimension(T item){
        this.item = item;
    }
    T getItem(){
        return item;
    }
    java.awt.Color color(){
        return item.getColor();
    }
    int getX(){
        return item.x;
    }
    int getY(){
        return item.y;
    }
    int getZ(){
        return item.z;
    }
}
public class BasicBounds {

}
