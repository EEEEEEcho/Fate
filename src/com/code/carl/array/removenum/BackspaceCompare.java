package com.code.carl.array.removenum;

public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) return false;
        System.out.println(getString(s));
        System.out.println(getString(t));
        return getString(s).equals(getString(t));
    }
    private String getString(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#'){
                if (sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BackspaceCompare b = new BackspaceCompare();
//        boolean b1 = b.backspaceCompare("y#fo##f"
//                , "y#f#o##f");
        b.getString("y#f#o##f");
    }
}
