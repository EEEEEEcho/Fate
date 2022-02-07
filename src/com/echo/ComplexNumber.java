package com.echo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Complex{
    int x;
    int y;
    double model;
    public Complex(int x,int y){
        this.x=x;
        this.y=y;
        this.model = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }
}
public class ComplexNumber {
    public static void main(String[] args) {
        ArrayList<Complex> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            scanner.nextLine();
            String orders[] = new String[n];
            for(int i = 0;i < n;i ++){
                //System.out.println("第" + i + "次输入");
                orders[i] = scanner.nextLine();
            }
            for(int i = 0;i < n;i ++){
                //System.out.println("第" + i  + "次输出");
                if(orders[i].equals("Pop")){
                    if(arrayList.size() == 0){
                        System.out.println("empty");
                    }
                    else{
                        Collections.sort(arrayList, new Comparator<Complex>() {
                            @Override
                            public int compare(Complex o1, Complex o2) {
                                if(o1.model < o2.model){
                                    return -1;
                                }
                                if(o1.model == o2.model){
                                    if(o1.y < o2.y){
                                        return -1;
                                    }
                                    else if(o1.y == o2.y){
                                        return 0;
                                    }
                                }
                                return 1;
                            }
                        });
                        Complex remove = arrayList.remove(arrayList.size() - 1);
                        int a = remove.x;
                        int b = remove.y;
                        System.out.println(a+"+i"+b);
                        System.out.println("SIZE = " + arrayList.size());
                    }
                }
                else if(orders[i].startsWith("Insert")){
                    String numAndOp = orders[i].split(" ")[1];
                    int a = Integer.parseInt(numAndOp.split("\\+i")[0]);
                    int b = Integer.parseInt(numAndOp.split("\\+i")[1]);
                    Complex complex = new Complex(a,b);
                    arrayList.add(complex);
                    System.out.println("SIZE = " + arrayList.size());
                }
            }
        }
    }
}
