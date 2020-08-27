package com.qiye;

import java.util.Scanner;

public class PackageTransfer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[] = new int[7];
        while (scanner.hasNext()){
            for(int i=1;i<=6;i ++){
                array[i] = scanner.nextInt();
            }
            int result = 0;
            int judge = 0;
            for(int i=1;i <= 6;i ++){
                if(array[i] == 0){
                    judge ++;
                }
            }
            if(judge == 6){
                break;
            }

            for(int i=6;i >= 1;i --){
                if (i == 6){
                    while (array[6] > 0){
                        result ++;
                        array[6] --;
                    }
                }
                if(i == 5){
                    while (array[5] > 0){
                        result ++;
                        for (int j = 0; j < 11; j ++){
                            if(array[1] > 0){
                                array[1] --;
                            }
                            else{
                                break;
                            }
                        }
                        array[5] --;
                    }
                }
                if(i == 4){
                    while (array[4] > 0){
                        result ++;
                        for(int j = 0;j < 5;j ++){
                            if(array[2] > 0){
                                array[2] --;
                            }
                            else{
                                break;
                            }
                        }
                        for(int j = 0;j < 20;j ++){
                            if (array[1] > 0){
                                array[1] --;
                            }
                            else {
                                break;
                            }
                        }
                        array[4] --;
                    }
                }
                if(i == 3){
                    while (array[3] > 0){
                        result ++;
                        for(int j = 0;j < 3;j ++){
                            if(array[3] > 0){
                                array[3] --;
                            }
                            else{
                                break;
                            }
                        }
                        for(int j = 0;j < 5;j ++){
                            if(array[2] > 0){
                                array[2] --;
                            }
                            else{
                                break;
                            }
                        }
                        for(int j = 0;j < 7;j ++){
                            if(array[1] > 0){
                                array[1] --;
                            }
                            else break;
                        }
                        array[3] --;
                    }
                }
                if(i == 2){
                    while (array[2] > 0){
                        result ++;
                        for (int j = 0;j < 8;j ++){
                            if(array[2] > 0){
                                array[2] --;
                            }
                            else {
                                break;
                            }
                        }
                        for(int j = 0;j < 32;j ++){
                            if(array[1] > 0){
                                array[1] --;
                            }
                            else break;
                        }
                        array[2] --;
                    }

                }
                if(i == 0){
                    while (array[1] > 0){
                        result ++;
                        for(int j = 0;j < 36;j ++){
                            if (array[1] > 0){
                                array[1] --;
                            }
                            else {
                                break;
                            }
                        }
                        array[1] --;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
