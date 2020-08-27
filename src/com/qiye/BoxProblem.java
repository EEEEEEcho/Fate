package com.qiye;

import com.echo.B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Box{
    int x;
    int y;

    @Override
    public String toString() {
        return "Box{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class BoxProblem {
    public static void main(String[] args) {
        int n = 9;
        int en[][] = new int[n][2];
        Scanner in = new Scanner(System.in);
        for(int i=0;i < n;i ++){
            for (int j =0; j < 2;j ++){
                en[i][j] = in.nextInt();
            }
        }
        maxEnvelopes(en);
    }
    public static int maxEnvelopes(int [][] envelpoes){
        ArrayList<Box> arrayList = new ArrayList<>();
        for(int i=0;i < envelpoes.length;i ++){
            Box box = new Box();
            box.x = envelpoes[i][0];
            box.y = envelpoes[i][1];
            arrayList.add(box);
        }
        Collections.sort(arrayList, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                if(o1.x > o2.x && o1.y > o2.y){
                    return 1;
                }
                else if(o1.x < o2.x && o1.y < o2.y){
                    return -1;
                }
                else if(o1.x == o2.x){
                    if(o1.y > o2.y){
                        return 1;
                    }
                    return -1;
                }
                else if(o1.y == o2.y){
                    if(o1.x > o2.x){
                        return 1;
                    }
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(arrayList);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = arrayList.size() - 1;i >=0 ;i --){
            int count = 1;
            int tmp = i;
            for(int j = i;j >=0;j --){
                if(arrayList.get(j).x < arrayList.get(tmp).x && arrayList.get(j).y < arrayList.get(tmp).y){
                    count ++;
                    tmp = j;
                }
            }
            list.add(count);
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}
