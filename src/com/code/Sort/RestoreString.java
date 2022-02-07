package com.code.Sort;

import java.util.HashMap;
import java.util.Map;

public class RestoreString {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder(s);
        Map<Integer,Character> map = new HashMap<>();
        for(int i=0;i < indices.length;i ++){
            map.put(indices[i],sb.charAt(i));
        }
        char[] chars = new char[indices.length];
        for(Map.Entry<Integer,Character> entry : map.entrySet()){
            chars[entry.getKey()] = entry.getValue();
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println("Hello".indexOf(0));

    }
}
