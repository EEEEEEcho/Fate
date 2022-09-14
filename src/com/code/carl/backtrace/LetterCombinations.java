package com.code.carl.backtrace;

import java.util.*;

public class LetterCombinations {
    private List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return ans;
        }
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrace(new StringBuilder(),digits,map,0);
        return ans;
    }
    public void backtrace(StringBuilder sb,String digits,Map<Character,String> map,int index){
        if (digits.length() == sb.length()){
            ans.add(sb.toString());
        }
        else {
            char c = digits.charAt(index);
            String sequence = map.get(c);
            for (int i = 0; i < sequence.length(); i++) {
                sb.append(sequence.charAt(i));
                backtrace(sb,digits,map,index + 1);
                sb.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
    }
}
