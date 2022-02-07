package com.code.backtracing;

import java.util.*;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0){
            return ans;
        }
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backTrace(ans,map,digits,0,new StringBuilder());
        return ans;
    }

    public void backTrace(List<String> ans,Map<Character,String> map,String digits,int index,StringBuilder sb){
        if (index == digits.length()){
            ans.add(sb.toString());
        }
        else{
            char keyNum = digits.charAt(index);
            String letters = map.get(keyNum);
            for (int i = 0; i < letters.length(); i++) {
                sb.append(letters.charAt(i));
                backTrace(ans,map,digits,index + 1,sb);
                //回溯，删除额外添加的字符
                sb.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();
        l.letterCombinations(new String("23"));
    }
}
