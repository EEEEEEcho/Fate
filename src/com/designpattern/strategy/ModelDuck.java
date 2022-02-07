package com.designpattern.strategy;

public class ModelDuck extends Duck{
    public ModelDuck(){
        //父类中没有初始化这两个行为，在子类中根据子类的特点来初始化为不同的行为
        super.flyBehavior = new FlyNoway();
        super.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I am model duck");
    }
}
