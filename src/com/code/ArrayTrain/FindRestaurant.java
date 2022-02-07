package com.code.ArrayTrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> col1 = new ArrayList<>(Arrays.asList(list1));
        ArrayList<String> col2  = new ArrayList<>(Arrays.asList(list2));
        col1.retainAll(col2);
        LinkedList<String> result = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        ArrayList<String> col3 = new ArrayList<>(Arrays.asList(list1));
        for (String str : col1){
            int a = col3.indexOf(str);
            int b = col2.indexOf(str);
            if (a + b < min){
                if (result.size() > 0){
                    result.clear();
                }
                min = a + b;
                result.add(str);
            }
            else if (a + b == min){
                result.add(str);
            }
        }
        String[] re = new String[result.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = result.get(i);
        }
        return re;
    }

    public static void main(String[] args) {
        FindRestaurant f = new FindRestaurant();
        String[] s1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] s2 = new String[]{"KFC","Shogun","Burger King"};
        System.out.println(Arrays.toString(f.findRestaurant(s1,s2)));
    }
}
