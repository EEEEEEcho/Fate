package com.thinkInJava.chapter14;

class Candy{
    static {
        System.out.println("Loading candy");
    }
}
class Gum{
    static {
        System.out.println("Loading Gum");
    }
}
class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}
public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside man");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("Gum");
        }
        catch (ClassNotFoundException e){
            System.out.println("Couldn't fin GUM");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("Aftering creating Cookie");
    }
}
