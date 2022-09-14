package com.interview.neteast;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();
        if (n == k){
            if (t + 1 == k){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append("1");
                }
                System.out.println(sb.toString());
            }
            else {
                System.out.println("-1");
            }
            return;
        }
        if(t == 0 && k == 0){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("0");
            }
            System.out.println(sb.toString());
            return;
        }
        if (t >= k){
            System.out.println("-1");
        }
        else {
            //先构造完要求的对数
            StringBuilder sb1 = new StringBuilder();
            int pair = t + 1;
            for (int i = 0;i < pair;i ++){
                sb1.append("1");
            }
            StringBuilder sb2 = new StringBuilder();
            int last = k - pair;
            for (int i = 0; i < last; i++) {
                sb2.append("0");
                sb2.append("1");
            }
            StringBuilder sb3 = new StringBuilder();
            int remain = n - sb1.length() - sb2.length();
            if (remain < 0){
                System.out.println("-1");
                return;
            }
            for (int i = 0;i < remain;i ++){
                sb3.append("0");
            }
            sb1.append(sb2).append(sb3);
            System.out.println(sb1);
        }
    }
}
