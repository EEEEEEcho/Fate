package com.interview.cs;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        boolean flg = false;
        if (line.startsWith("-")){
            line = line.replaceFirst("-","");
            flg = true;
        }
        StringBuilder sb = new StringBuilder(line);
        sb.reverse();
        long result = Long.parseLong(sb.toString());
        if (flg){
            result = - result;
        }
        if (result >= (long) Math.pow(2,31) || result < (long) -Math.pow(2,31)){
            System.out.println(0);
        }
        else {
            System.out.println(result);
        }
    }
}
