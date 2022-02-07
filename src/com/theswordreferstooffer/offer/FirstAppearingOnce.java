package com.theswordreferstooffer.offer;

import java.util.HashMap;
import java.util.Map;

public class FirstAppearingOnce {
    StringBuilder sb = new StringBuilder();
    char[] chars = new char[256];
    //HashMap<Character,Integer> hashMap = new HashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
        chars[ch] ++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char str[] = sb.toString().toCharArray();
        for(char c : str){
            if(chars[c] == 1){
                return c;
            }
        }
        return '#';
    }
}
