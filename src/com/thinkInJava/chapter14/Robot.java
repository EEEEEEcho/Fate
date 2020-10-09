package com.thinkInJava.chapter14;

import java.util.List;

public interface Robot {
    String name();
    String model();
    List<Operation> operations();
    class Test{
        public static void test(Robot t){
            if(t instanceof Null){
                System.out.println("Null Robot");
            }
            System.out.println("Robot name: " + t.name());
            System.out.println("Robot model: " + t.model());
            for(Operation operation : t.operations()){
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
