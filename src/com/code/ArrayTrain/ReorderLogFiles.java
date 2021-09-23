package com.code.ArrayTrain;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        String[] result = new String[logs.length];
        for (int i = logs.length - 1,j = result.length - 1;i >= 0;i --){
            char lastIndex = logs[i].charAt(logs[i].length() - 1);
            if (lastIndex>= 48 && lastIndex <= 57){
                result[j --] = logs[i];
            }
        }
        //System.out.println(Arrays.toString(result));
        Arrays.sort(logs, (s1, s2) -> {
            String tmp1 = s1.substring(s1.indexOf(" "));
            String tmp2 = s2.substring(s2.indexOf(" "));
            if (!tmp1.equals(tmp2)){
                return tmp1.compareTo(tmp2);
            }
            else{
                String tag1 = s1.split(" ")[0];
                String tag2 = s2.split(" ")[0];
                return tag1.compareTo(tag2);
            }
        });
        for (int i = 0,j = 0;i < logs.length;i ++){
            int lastIndex = logs[i].charAt(logs[i].length() - 1);
            if (lastIndex <48 || lastIndex > 57){
                result[j ++] = logs[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ReorderLogFiles r = new ReorderLogFiles();
        String[] test = new String[]{
                "a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"
        };
        String[] strings = r.reorderLogFiles(test);
        System.out.println(Arrays.toString(strings));
//        int i = "dig1 8 1 5 1".indexOf(" ");
//        System.out.println("dig1 8 1 5 1".substring(i).trim());
    }
}
