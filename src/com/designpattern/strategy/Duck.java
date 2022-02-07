package com.designpattern.strategy;

public abstract class Duck {
    //面向行为编程，将具体行为定义为接口
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){

    }

    public abstract void display();

    public void peformFly(){
        flyBehavior.fly();
    }

    public void peformQuack(){
        quackBehavior.quack();;
    }

    public void swim(){
        System.out.println("All ducks can swim,even decoys!");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
