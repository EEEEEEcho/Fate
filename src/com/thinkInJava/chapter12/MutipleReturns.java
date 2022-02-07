package com.thinkInJava.chapter12;

public class MutipleReturns {
    public static void f(int i){
        System.out.println("Initialization that requires cleanup");
        try{
            System.out.println("Point 1");
            if(i == 1) return;  //虽然有return语句，但是finally中的语句还是要先执行，才return
            System.out.println("Point 2");
            if(i == 2) return;
            System.out.println("Point 3");
            if(i == 3) return;
            System.out.println("end");
        }
        finally {
            System.out.println("Performing cleanup");
        }
    }

    public static void main(String[] args) {
        for(int i=1;i <= 4;i ++){
            f(i);
        }
    }
}
