package com.echo;
import java.util.Scanner;

public class FindNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];
        for(int i=0;i < array.length;i ++){
            array[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int inarray[] = new int[m];
        for(int i=0;i < m;i ++){
            inarray[i] = scanner.nextInt();
        }
        int flag[] = new int[m];
        for(int i=0;i < inarray.length;i ++){
            for(int j=0;j < array.length;j ++){
                if(inarray[i] == array[j]){
                    flag[i] = 1;
                    break;
                }
            }
        }
        for(Integer integer:flag){
            if(integer == 1){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
