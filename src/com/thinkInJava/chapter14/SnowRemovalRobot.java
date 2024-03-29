package com.thinkInJava.chapter14;

import java.util.Arrays;
import java.util.List;

public class SnowRemovalRobot implements Robot {
    private String name;

    public SnowRemovalRobot(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    public String model() {
        return "SnowBot Series l1";
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                                 @Override
                                 public String description() {
                                     return name + " can shovel snow";
                                 }

                                 @Override
                                 public void command() {
                                     System.out.println(name + " shoveling snow");
                                 }
                             },
                new Operation() {
                    @Override
                    public String description() {
                        return name + " can chip ice";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " chip ice");
                    }
                },
                new Operation() {
                    @Override
                    public String description() {
                        return name + " can clear roof";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " clear roof");
                    }
                }
        );
    }

    public static void main(String[] args) {
        Robot.Test.test(new SnowRemovalRobot("Slusher"));
    }
}
