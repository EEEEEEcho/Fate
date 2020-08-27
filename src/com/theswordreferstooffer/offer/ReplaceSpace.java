package com.theswordreferstooffer.offer;

import java.util.Scanner;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String result = str.toString().replaceAll(" ","%20");
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String re = new ReplaceSpace().replaceSpace(new StringBuffer(s));
        System.out.println(re);
    }
}
