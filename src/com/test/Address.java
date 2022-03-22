package com.test;

public class Address implements Cloneable{
    private String name;

    public Address() {
    }

    public Address(String name) {
        this.name = name;
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
