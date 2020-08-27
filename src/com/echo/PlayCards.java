package com.echo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class PlayCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String me = scanner.nextLine();
        String you = scanner.nextLine();
        int youLength = you.length();
        switch (youLength){
            case 1:
                oneCard(me,you);
                break;
            case 2:
                findSeriesCard(me,you,2);
                break;
            case 3:
                findSeriesCard(me,you,3);
                break;
            case 4:
                findSeriesCard(me,you,4);
                break;
            case 5:
                findSortCard(me,you);
                break;
        }
    }
    public static void oneCard(String me,String you){
        char list[] = me.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        for(Character character : list){
            set.add(character);
        }
        for(Character character:set){
            if(you.toCharArray()[0] < character){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
    public static void findSeriesCard(String me,String you,int num){
        char array[] = me.toCharArray();
        char obj = you.toCharArray()[0];
        for(int i = 0;i <= array.length - num;i ++){
            if(array[i] > obj && array[i + num - 1] == array[i]){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
    public static void findSortCard(String me,String you){
        char list[] = me.toCharArray();
        char obj = you.toCharArray()[0];
        HashSet<Character> set = new HashSet<Character>();
        //先去个重  其实应该将去重抽一个方法，
        for(Character character : list){
            set.add(character);
        }
        Object[] array = set.toArray();

        for(int i = 0;i < set.size() - 4;i ++){
            //如果是连续的 从我的牌中找到第一个比你的顺子第一张大的牌
            //然后往后数四个，如果数到的第四个正好也比当前的牌大四个数
            //说明我的也是顺子
            if((Character)array[i] > obj && ((Character)array[i + 4]- (Character)array[i]) == 4){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
