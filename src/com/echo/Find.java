package com.echo;

import java.util.Scanner;

public class Find {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StringBuilder obj = new StringBuilder(s);
        int n = scanner.nextInt();
        //消化回车
        scanner.nextLine();
        for(int i= 0 ;i < n;i ++){
            String commond = scanner.next();
            if(commond.startsWith("0")){
                String part = obj.substring(commond.charAt(1) - 48,commond.charAt(2) - 48);
                StringBuilder partBuilder = new StringBuilder(part);
                part = partBuilder.reverse().toString();
                obj = obj.replace(commond.charAt(1) - 48,commond.charAt(2) - 48,part);
                System.out.println(obj.toString());
            }
            else if(commond.startsWith("1")){
                String append = commond.substring(commond.charAt(2) - 48 + 1);
                //System.out.println(append);
                obj = obj.replace(commond.charAt(1) - 48,commond.charAt(2) - 48+1,append);
                System.out.println(obj.toString());
            }
        }
        scanner.close();
    }
}
