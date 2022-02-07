package com.code.Sort;

import java.util.Arrays;

public class SortByBits {
//    private int countNum(int flg){
//        int count = 0;
//        int r = 0;
//        while (flg != 0){
//            r = flg % 2;
//            if(r == 1){
//                count ++;
//            }
//            flg /= 2;
//        }
//        return count;
//    }
    public int[] sortByBits(int[] arr) {
        Integer[] integers = new Integer[arr.length];
        for(int i=0;i < arr.length;i ++){
            integers[i] = arr[i];
        }
        Arrays.sort(integers, (o1, o2) -> {
            Integer first = Integer.bitCount(o1);
            Integer second = Integer.bitCount(o2);
            if(first.equals(second)){
                return o1.compareTo(o2);
            }
            else{
                return first.compareTo(second);
            }
        });
        for(int i=0;i < arr.length;i ++){
            arr[i] = integers[i];
        }
        return arr;
    }

    public int[] sortByBits2(int[] arr) {
        /**人家的神仙解法，直接将1的个数提到最高位然后排序 */
        int[] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(map);
        for (int i = 0; i < map.length; i++) {
            map[i] = map[i] % 10000000;
        }
        return map;
    }


    public static void main(String[] args) {
        SortByBits s = new SortByBits();
        //System.out.println(s.countNum(15));
        System.out.println(Integer.bitCount(8));
    }
}
