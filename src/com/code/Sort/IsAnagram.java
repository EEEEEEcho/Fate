package com.code.Sort;
import java.util.Arrays;
public class IsAnagram {
//    public boolean isAnagram(String s,String t){
//        /**
//         * 模式匹配
//         */
//        int i = 0;
//        int j = 0;
//        int count = i;
//        for(;i < s.length();i ++){
//            System.out.println(j);
//            if(s.charAt(i) == t.charAt(0)){
//                int now = i;
//                for (;j < t.length();j ++){
//                    if(s.charAt(now) != t.charAt(j)){
//                        i = count + 1;
//                        j = 0;
//                        break;
//                    }
//                    else{
//                        now ++;
//                    }
//                }
//            }
//        }
//        return j == t.length();
//    }
    public boolean isAnagram(String s,String t){
        if(s.length() != t.length()){
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        s = new String(sArr);
        t = new String(tArr);
        return s.equals(t);
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram("abc","bca"));
    }
}
