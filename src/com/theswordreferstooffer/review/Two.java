package com.theswordreferstooffer.review;

public class Two {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        Two t = new Two();
        System.out.println(t.replaceSpace(new StringBuffer("We Are Happy")));
    }
}
