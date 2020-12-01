package com.thinkInJava.chapter18;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {
    public static String pformat(Collection<?> c){
        if(c.size() == 0){
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Object item : c){
            if(c.size() != 1){
                stringBuilder.append("\n");
            }
            stringBuilder.append(item);
        }
        if(c.size() != 1){
            stringBuilder.append("\n");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    public static void pprint(Collection<?> c){
        System.out.println(pformat(c));
    }
    public static void pprint(Object[] c){
        System.out.println(pformat(Arrays.asList(c)));
    }
}
