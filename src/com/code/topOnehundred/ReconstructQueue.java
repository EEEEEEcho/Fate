package com.code.topOnehundred;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        //[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        //按照第一个元素（身高）降序排序，第二个元素（前面有几个元素大于等于它的身高）升序排序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            else{
                return o2[0] - o1[0];
            }
        });
        //[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int k = people[i][1];
            if (k <= list.size()){
                list.add(people[i]);
            }
            else{
                list.add(k,people[i]);
            }
        }
        list.forEach(t -> System.out.print(Arrays.toString(t) + " "));
        System.out.println();
        for (int i = 0; i < people.length; i++) {
            people[i] = list.get(i);
        }
        return people;
    }
}
