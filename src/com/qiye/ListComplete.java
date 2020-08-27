package com.qiye;

import java.util.Scanner;

public class ListComplete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int pass = scanner.nextInt();
            int next = scanner.nextInt();
            int l1 = scanner.nextInt();
            int l2 = scanner.nextInt();
            int re1,re2,re3,re4;
            if(pass < l1){
                re1 = l1 - pass;
                if(next >= re1){
                    re2 = l1;
                    next -= re1;
                    if(next >= l2){
                        re3 = l2;
                        re4 = l2;
                        System.out.println(re1 + " " + re2 + " " + re3 + " " + re4);
                    }
                    else{
                        re3 = 0;
                        re4 = l2 - next;
                        System.out.println(re1 + " " + re2 + " " + re3 + " " + re4);
                    }
                }
                else{
                    re1 = pass;
                    re2 = pass + next;
                    re3 = 0;
                    re4 = 0;
                    System.out.println(re1 + " " + re2 + " " + re3 + " " + re4);
                }

            }
            else{
                re1 = l1;
                re2 = l1;
                int left = pass - l1;
                if(left >= l2){
                    re3 = l2;
                    re4 = l2;
                    System.out.println(re1 + " " + re2 + " " + re3 + " " + re4);
                }
                else{
                    re3 = left;
                    re4 = re3 + next;
                    if(re4 <= l2 ){
                        System.out.println(re1 + " " + re2 + " " + re3 + " " + re4);
                    }
                    else {
                        re4 = l2;
                        System.out.println(re1 + " " + re2 + " " + re3 + " " + re4);
                    }
                }
            }
        }
    }
}
