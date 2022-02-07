package com.code.ArrayTrain;

import java.util.ArrayList;
import java.util.Arrays;

public class CountCharacters {
    public int countCharacters(String[] words, String chars) {
        ArrayList<Character> mother = new ArrayList<>();
        char[] chars1 = chars.toCharArray();
        for (char c :chars1){
            mother.add(c);
        }
        int count = 0;
        for (int i = 0; i <words.length; i++) {
            char[] charArray = words[i].toCharArray();
            ArrayList<Character> tmp = new ArrayList<>();
            for (int j = 0; j < charArray.length; j++) {
                tmp.add(charArray[j]);
            }
            if (mother.containsAll(tmp)){
                count += charArray.length;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('t');
        list.add('a');
        list.add('c');
        list.add('h');
        ArrayList<Character> list1 = new ArrayList<>();
        list1.add('a');
        list1.add('a');
        //list1.add('h');
        System.out.println(list.containsAll(list1));
    }
}
