package com.code.ArrayTrain;

import java.util.*;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        TreeSet<Character> set = new TreeSet<>();
        for(char c : letters){
            set.add(c);
        }
        Iterator<Character> iterator = set.iterator();
        letters = new char[set.size()];
        int i = 0;
        while (iterator.hasNext()){
            letters[i++] = iterator.next();
        }
        int index = Arrays.binarySearch(letters, target);
        if (index >= 0){
            if (index + 1 < letters.length){
                return letters[index + 1];
            }
            return letters[0];
        }
        else{
            index = -index;
            if (index == letters.length + 1){
                return letters[0];
            }
            return letters[index - 1];
        }
    }

    public static void main(String[] args) {
        NextGreatestLetter n = new NextGreatestLetter();
        n.nextGreatestLetter(new char[]{'c', 'f', 'j'},'d');
    }
}
