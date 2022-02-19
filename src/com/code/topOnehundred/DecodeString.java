package com.code.topOnehundred;

import java.util.LinkedList;

public class DecodeString {
    public String decodeString(String s) {
//        if (s == null || s.length() == 0){
//            return "";
//        }
//        LinkedList<Integer> nums = new LinkedList<>();
//        nums.push(-1);
//        LinkedList<String> chars = new LinkedList<>();
//        StringBuilder sb = new StringBuilder();
//        for (char c : s.toCharArray()){
//            if (c == ']'){
//                int num = 0;
//                int k = 0;
//                if (!nums.isEmpty() && nums.peek() == -1){
//                    nums.pop();
//                }
//                while (!nums.isEmpty() && nums.peek() != -1){
//                    num += nums.pop() * Math.pow(10,k++);
//                }
//                if (!nums.isEmpty()){
//                    nums.pop();
//                }
//
//                StringBuilder tmp = new StringBuilder();
//                while (!chars.isEmpty() && !chars.peek().equals("-")){
//                    String chr = chars.pop();
//                    tmp.append(chr);
//                }
//                if (!chars.isEmpty()){
//                    chars.pop();
//                }
//                StringBuilder tmp2 = new StringBuilder();
//                for (int i = 0; i < num; i++) {
//                    tmp2.append(tmp);
//                }
//                chars.push(tmp2.toString());
//            }
//            else if (c >= '0' && c <= '9'){
//                nums.push(c - 48);
//            }
//            else if(c == '['){
//                chars.push("-");
//                nums.push(-1);
//            }
//            else {
//                chars.push(c + "");
//            }
//        }
//        while (!chars.isEmpty() && !chars.peek().equals("-")){
//            sb.append(chars.poll());
//        }
//        return sb.reverse().toString();
        if (s == null || s.length() == 0){
            return "";
        }

        char[] array = s.toCharArray();
        int i = 0;
        LinkedList<Integer> numsStack = new LinkedList<>();
        LinkedList<String> charStack = new LinkedList<>();
        while (i < array.length){
            char c = array[i];
            if (c >= '0' && c <= '9'){
                int j = i;
                int sum = 0;
                while (j + 1 < array.length && (array[j + 1] >= '0' && array[j + 1] <= '9')){
                    j ++;
                }
                int pow = j - i;
                while (pow >= 0){
                    sum += Math.pow(10,pow) * (array[i] - 48);
                    pow --;
                    i ++;
                }
                numsStack.push(sum);
            }
            else if (c == '['){
                charStack.push("-");
                i ++;
            }
            else if (c ==']'){
                StringBuilder sb1 = new StringBuilder();
                while (!charStack.isEmpty() && !(charStack.peek().equals("-"))){
                    sb1.append(charStack.pop());
                }
                //去除 -
                if (!charStack.isEmpty()){
                    charStack.pop();
                }
                int num = numsStack.pop();
                StringBuilder sb2 = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    sb2.append(sb1);
                }
                charStack.push(sb2.toString());
                i++;
            }
            else {
                charStack.push(c + "");
                i ++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!charStack.isEmpty() && !charStack.peek().equals("-")){
            sb.append(charStack.poll());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        DecodeString d = new DecodeString();
        String s = d.decodeString(
                "30[car]");
        System.out.println(s);

    }
}
