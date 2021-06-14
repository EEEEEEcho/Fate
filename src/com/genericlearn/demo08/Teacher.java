package com.genericlearn.demo08;

public class Teacher extends People{
    public int age;

    public Teacher(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
