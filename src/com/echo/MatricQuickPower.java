package com.echo;

import java.util.Scanner;

public class MatricQuickPower {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int n = input.nextInt();
            int k = input.nextInt();

            int array[][] = new int[n][n];
            for(int j=0;j < array.length;j ++){
                for(int m = 0;m < array[0].length;m ++){
                    array[j][m] = input.nextInt();
                }
            }

            int result[][] = mutiplyPower(array,k);
            for(int p=0;p < result.length;p ++){
                for(int q = 0;q < result[0].length; q++){
                    System.out.print(result[p][q] + " ");
                }
                System.out.println();
            }
        }
    }
    public static int[][] multiply(int a[][],int b[][]){
        //2x3 * 3x2 = 2x2
        int array[][] = new int[a.length][b[0].length];
        for(int i=0;i<a.length;i++){
            for(int j = 0;j < b[0].length;j ++){
                for(int k = 0;k < a[0].length;k ++){
                    array[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return array;
    }
    public static int[][] mutiplyPower(int[][] a,int n){
        int result[][] = new int[a.length][a[0].length];
        //将result初始化为单位阵
        for(int i=0;i < a.length;i ++){
            for(int j=0;j < a[0].length;j ++){
                if(i == j){
                    result[i][j] = 1;
                }
                else{
                    result[i][j] = 0;
                }
            }
        }
        while (n != 0){
            //&运算将n转换为二进制然后每一位 与 1 的二进制与 比如 3 & 1 为 11 & 01 结果为 1
            //这步操作 就是将n拆分为二进制格式 详情见上面的博客链接
            if((n&1) == 1){
                result = multiply(result,a);
            }
            //右移一位
            n = n>>1;
            a = multiply(a,a);
        }
        return result;
    }
}
