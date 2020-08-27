package com.proxyStudy.dynamicProxy;

public class Student implements Person {
    private String name;
    public Student(String name){
        this.name = name;
    }
    @Override
    public void giveMoney() {
        try{
            //数钱花了一秒
            Thread.sleep(1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(this.name + "上交班费50元");
    }
}
