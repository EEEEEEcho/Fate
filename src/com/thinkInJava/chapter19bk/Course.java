package com.thinkInJava.chapter19bk;

public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] foods;
    private Course(Class<? extends Food> clazz){
        foods = clazz.getEnumConstants();
    }
    public Food randomSelection(){
        return Enums.random(foods);
    }
}
