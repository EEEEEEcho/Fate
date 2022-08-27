package com.interview.ms;

import java.util.*;

public class Three {
    public int solution(String S) {
        // write your code in Java 8 (Java SE 8)
        if(S == null || S.length() == 0){
            return 0;
        }
        LinkedHashMap<Character, List<Integer>> map = new LinkedHashMap<>();
        int n = S.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            if (!map.containsKey(c)){
                map.put(c,new ArrayList<>(Arrays.asList(i,1)));
            }
            else {
                List<Integer> list = map.get(c);
                list.set(1,list.get(1) + 1);
                int times = list.get(1);
                if (times % 2 == 0){
                    char flg = '#';
                    for (int j = i - 1; j >= 0; j--) {
                        char tmp = S.charAt(j);
                        if (map.get(tmp).get(1) % 2 == 0){
                            flg = tmp;
                        }
                        else {
                            break;
                        }
                    }
                    if (flg != '#'){
                        List<Integer> start = map.get(flg);
                        max = Math.max(i - start.get(0) + 1,max);
                    }
                }
            }


        }
        return max;
    }

    public static void main(String[] args) {
        Three three = new Three();
        //bdaaadadb
        //abacb
        int max = three.solution("abcba");
        System.out.println(max);
    }
}
