package com.thinkInJava.chapter12;
class ThreeException extends Exception{}
public class FinallyWorks {
    public static int count = 0;

    public static void main(String[] args) {
        while (true){
            try {
                if (count ++ == 0){
                    throw new ThreeException();
                }
                System.out.println("No Exception");
            }
            catch (ThreeException e){
                System.out.println("Three Exception");
            }
            finally {
                System.out.println("In finally clause");
                if (count == 2) break;
            }
        }
    }
}
