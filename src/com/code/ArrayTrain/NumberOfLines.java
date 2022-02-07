package com.code.ArrayTrain;

public class NumberOfLines {
    public int[] numberOfLines(int[] widths, String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int width = 100;
        for (int i = 0;i < chars.length;i ++){
            width -= widths[(int) chars[i] - 97];
            if (width == 0){
                count += 1;
                width = 100;
            }
            else if (width < 0){
                count += 1;
                width = 100;
                i -= 1;
            }
        }
        if (width != 100){
            return new int[]{count + 1,100 - width};
        }
        else{
            return new int[]{count,width};
        }
    }

    public static void main(String[] args) {
        System.out.println((int)'a' - 97);
    }
}
