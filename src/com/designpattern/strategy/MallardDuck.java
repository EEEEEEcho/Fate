package com.designpattern.strategy;

public class MallardDuck extends Duck{
    public MallardDuck(){
        super.flyBehavior = new FlyWithWings();
        super.quackBehavior = new Quack();
    }
    @Override
    public void display() {
        System.out.println("I am a real Mallard Duck");
    }
}
