package com.test;

public class Person implements Cloneable{
    private Address address;

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    public Person() {
    }

    public Person(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(new Address("武汉"));
        Person clone = person.clone();
        System.out.println(person.getAddress() == clone.getAddress());
    }
}
