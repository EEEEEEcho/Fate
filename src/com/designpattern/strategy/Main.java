package com.designpattern.strategy;

/**
 * 策略设计模式
 * 定义了算法族，分别封装起来，本例中就是飞的行为和叫的行为
 * 让它们之间可以相互替换，此模式让算法的变化独立于使用算法的客户
 */
public class Main {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.peformFly();
        mallardDuck.peformQuack();

        Duck model = new ModelDuck();
        model.peformFly();
        model.setFlyBehavior(new FlyRocketPower());
        model.peformFly();
    }
}
