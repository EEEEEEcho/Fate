package com.theswordreferstooffer.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class SortIndex{
    int x;
    int y;
}
/**
 *  输入一个递增排序的数组和一个数字 S，在数组中查找两个数，是的他 们的和正好是 S，
 *  如果有多对数字的和等于 S，输出两个数的乘积最小的
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int index = 0;
        for(int i=0;i < array.length;i ++){
            if(array[i] > sum){
                index = i;
                break;
            }
        }
        if(index == 0){
            index = array.length - 1;
        }
        ArrayList<SortIndex> list = new ArrayList<>();
        for(int i=0;i <= index;i ++){
            for(int j = i +1;j <=index;j ++){
                if(array[j] + array[i] == sum){
                    SortIndex s = new SortIndex();
                    s.x = array[i];
                    s.y = array[j];
                    list.add(s);
                }
            }
        }
        Collections.sort(list, new Comparator<SortIndex>() {
            @Override
            public int compare(SortIndex o1, SortIndex o2) {
                if(o1.x * o1.y < o2.x * o2.y){
                    return -1;
                }
                return 1;
            }
        });
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(list.size() == 0){
            return arrayList;
        }
        SortIndex t = list.get(0);
        int max = Math.max(t.x,t.y);
        int min = Math.min(t.x,t.y);
        arrayList.add(min);
        arrayList.add(max);
        return arrayList;
    }

    /**
     * ：定义两个指针，分别从前面和后面进行遍历。间隔越远乘积越小，所以是 最先出现的两个数乘积最小
     * @param args
     */
    public ArrayList<Integer> FindNumbersWithSum1(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(array == null){
            return arrayList;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            int s = array[left] + array[right];
            if(s == sum){
                arrayList.add(array[left]);
                arrayList.add(array[right]);
                return arrayList;
            }
            else {
                if(s > sum){
                    right --;
                }
                else {
                    left ++;
                }
            }
        }
        return arrayList;
    }
    public static void main(String[] args) {
        FindNumbersWithSum f = new FindNumbersWithSum();
        ArrayList<Integer> t = new ArrayList<>();
        t = f.FindNumbersWithSum(new int[]{1,2,4,7,11,16},10);
        System.out.println(t);
    }
}
