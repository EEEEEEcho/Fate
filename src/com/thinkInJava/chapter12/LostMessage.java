package com.thinkInJava.chapter12;

class VeryImportantException extends Exception{
    public String toString(){
        return "A very important exception!";
    }
}
class HoHumException extends Exception{
    public String toString(){
        return "A trivial exception";
    }
}
public class LostMessage {
    void f() throws VeryImportantException{
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException{
        throw new HoHumException();
    }
    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f(); //此处会抛出VeryImportantException，但是并不会捕获，直接进入finally中
            }
            finally {
                lm.dispose();   //finally中再抛出HoHumException，最后丢失了VeryImportantException
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
