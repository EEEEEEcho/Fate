package com.thinkInJava.chapter15;

import java.util.*;

class Customer {
    private static long counter = 1;
    private final long id = counter ++;
    private Customer(){

    }
    public String toString(){
        return "Customer " + id;
    }
    public static Generator<Customer> generator(){
        return () -> new Customer();
    }
}

class Teller{
    private static long counter = 1;
    private final long id = counter++;
    private Teller(){

    }
    public String toString(){
        return "Teller " + id;
    }
    public static Generator<Teller> generator = () -> new Teller();
}
public class BankTeller {
    public static void server(Teller t,Customer c){
        System.out.println(t + "servers " + c);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line,Customer.generator(),15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers,Teller.generator,4);
        for(Customer c : line){
            server(tellers.get(random.nextInt(tellers.size())),c);
        }
    }
}
