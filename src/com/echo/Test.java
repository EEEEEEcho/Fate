package com.echo;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while (in.hasNext()) {
            n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int m = in.nextInt();
                System.out.println(Integer.toBinaryString(m));
            }
        }
    }
}
