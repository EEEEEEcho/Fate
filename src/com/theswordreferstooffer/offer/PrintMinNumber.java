package com.theswordreferstooffer.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印 能拼接出的所有数字中最小的一个
 */
public class PrintMinNumber {
    /**
     * ：先将整型数组转换成 String 数组，然后将 String 数组排序，最后将排好序 的字符串数组拼接出来。
     * 关键就是制定排序规则。或使用比较和快排的思想，将前 面的数和最后的数比较，
     * 若小则放到最前面，最后再递归调用
     * @param numbers
     * @return
     */
    public String printMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return "";
        }
        String str[] = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i < str.length;i ++){
            str[i] = String.valueOf(numbers[i]);
        }
        //指定排序规则，如果前 + 后 > 后 + 前 返回 前 + 后
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });
        for(String s : str){
            sb.append(s);
        }
        return sb.toString();
    }
}
