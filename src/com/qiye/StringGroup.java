package com.qiye;

import java.util.*;

public class StringGroup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        for(int i=0;i < s.length();i ++){
            for(int j=0;j < s.length() - i;j ++){
                String result = s.substring(j,j+i+1);
                hashSet.add(result);
            }
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for(String end:hashSet){
            arrayList.add(end);
        }
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                //(s1.length() == s2.length() && s1 > s2) || s1.length() > s2.length()
                if(s1.length() > s2.length()){
                    return 1;
                }
                else if(s1.length() == s2.length()){
                    int i = 0;
                    while (i < s1.length()){
                        if(s1.charAt(i) > s2.charAt(i)){
                            return 1;
                        }
                        else if(s1.charAt(i) < s2.charAt(i)) {
                            return -1;
                        }
                        i++;
                    }
                }
                return -1;
            }
        });
        for(String out : arrayList){
            System.out.print(out + " ");
        }
    }
}
