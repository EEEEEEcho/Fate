package com.qiye;

import java.util.*;

public class DeleteSameWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char array[] = s.toCharArray();
        /**
         * LinkedHashMap。它内部有一个链表，保持插入的顺序。迭代的时候，也是按照插入顺序迭代，而且迭代比HashMap快。
         */
        Set<Character> set = new LinkedHashSet<>();
        for(int i=0;i < array.length;i ++){
            set.add(array[i]);
        }
        String result = "";
        for(Character c : set){
            result += c;
        }
        System.out.println(result);
    }
}
