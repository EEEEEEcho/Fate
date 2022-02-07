package com.qiye;

        import java.math.BigInteger;
        import java.util.Scanner;

public class CircleNumCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        int n = scanner.nextInt();
        String s2 = scanner.next();
        int m = scanner.nextInt();
        s1 = repeat(s1,n);
        s2 = repeat(s2,m);
        BigInteger bg1 = new BigInteger(s1);
        // System.out.println(bg1);
        BigInteger bg2 = new BigInteger(s2);
        // System.out.println(bg2);
        if(bg1.compareTo(bg2) > 0){
            System.out.println("Greater");
        }
        else if(bg1.compareTo(bg2)  == 0){
            System.out.println("Equal");
        }
        else{
            System.out.println("Less");
        }
    }
    public static String repeat(String s,int x){
        String sub = s;
        for(int i=0;i < x - 1;i ++){
            s +=sub;
        }
        return s;
    }
}
