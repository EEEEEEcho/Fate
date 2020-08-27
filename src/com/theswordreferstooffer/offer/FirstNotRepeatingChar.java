package com.theswordreferstooffer.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class FirstNotRepeatingChar {
    int FirstNotRepeatingChar(String str) {
        if(str.equals("") || str == null){
            return -1;
        }
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0;i < str.length();i ++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i)) + 1);
            }
            else {
                map.put(str.charAt(i),1);
            }
        }
        Character c = null;
        for(Map.Entry entry: map.entrySet()){
            //System.out.println(entry.getKey() + ":" + entry.getValue());
            if((Integer)entry.getValue() == 1){
                c = (Character)entry.getKey();
               //System.out.println(c);
                break;
            }
        }
        if(c != null){
            return str.indexOf(c);
        }
        return 0;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar f = new FirstNotRepeatingChar();
        int re = f.FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp");
        System.out.println(re);
    }
}
