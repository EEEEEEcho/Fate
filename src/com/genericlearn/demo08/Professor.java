package com.genericlearn.demo08;

public class Professor extends Teacher{
    public int level;

    public Professor(String name, int age, int level) {
        super(name, age);
        this.level = level;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", age=" + age +
                '}';
    }
}
