package com.designpattern.strategy;

public class FlyRocketPower implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("I am flying with rocket!");
    }
}
