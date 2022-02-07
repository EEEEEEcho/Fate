package com.qiye;

import java.util.Scanner;

public class HuiWen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(s);
        if(s.equals(stringBuilder.reverse().toString())){
            System.out.println(s.length());
            return;
        }
        //int i = 0;
        int j = 1;
        while (true){
            String tmp1 = s.substring(0,j);
            String tmp2 = s.substring(j,s.length());
            //System.out.println("tmp1:" + tmp1);
            //System.out.println("tmp2:" + tmp2);
            StringBuilder sb = new StringBuilder(tmp2);
            if(sb.reverse().toString().equals(tmp2)){
                StringBuilder sb2 = new StringBuilder(tmp1);
                s += sb2.reverse();
                //System.out.println(s);
                System.out.println(s.length());
                break;
            }
            j++;
        }
    }
}
