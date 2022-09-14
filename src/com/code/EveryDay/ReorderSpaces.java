package com.code.EveryDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderSpaces {
    public String reorderSpaces(String text) {
        int count = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' '){
                count ++;
            }
        }
        String[] s = text.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals("")){
                list.add(s[i]);
            }
        }
        if (list.size() == 1){
            StringBuilder sb = new StringBuilder(list.get(0));
            for (int i = 0; i < count; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int x = count / (list.size() - 1);
        int y = count % (list.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (String str: list){
            sb.append(str);
            for (int i = 0; i < x; i++) {
                sb.append(" ");
            }
        }
        StringBuilder ansSb = new StringBuilder(sb.toString().trim());
        for (int i = 0; i < y; i++) {
            ansSb.append(" ");
        }
        return ansSb.toString();
    }

    public static void main(String[] args) {
        ReorderSpaces reorderSpaces = new ReorderSpaces();
        String s = reorderSpaces.reorderSpaces("  this   is  a sentence ");
        System.out.println(s);
    }
}
