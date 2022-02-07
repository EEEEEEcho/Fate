package com.qiye;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Bear{
    int fight;
    int hungry;
    int index;
}
public class BearEatCandy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bearCount = scanner.nextInt();
        int candyCount = scanner.nextInt();
        int candyArray[] = new int[candyCount];
        for(int i=0;i < candyCount;i ++){
            candyArray[i] = scanner.nextInt();
        }
        Bear bears[] = new Bear[bearCount];
        for(int i=0;i<bearCount;i ++){
            bears[i] = new Bear();
            bears[i].fight = scanner.nextInt();
            bears[i].hungry = scanner.nextInt();
            bears[i].index = i;
        }

        Arrays.sort(candyArray);
        Arrays.sort(bears, new Comparator<Bear>() {
            @Override
            public int compare(Bear bear1, Bear bear2) {
                if(bear1.fight > bear2.fight){
                    return 1;
                }
                else if(bear1.fight == bear2.fight){
                    return 0;
                }
                return -1;
            }
        });
        for(int i = bears.length - 1;i >=0;i --){
            for (int j = candyArray.length - 1;j >=0;j --){
                if(candyArray[j] <= bears[i].hungry){
                    bears[i].hungry -= candyArray[j];
                    candyArray[j] = 0;
                }
            }
        }
        Arrays.sort(bears, new Comparator<Bear>() {
            @Override
            public int compare(Bear o1, Bear o2) {
                if(o1.index > o2.index){
                    return 1;
                }
                return -1;
            }
        });
        for(Bear bear : bears){
            System.out.println(bear.hungry);
        }
    }
}
