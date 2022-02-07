package com.qiye;

import java.util.Scanner;

class People{
    int h;
    int a;
    int d;

    public People(int h, int a, int d) {
        this.h = h;
        this.a = a;
        this.d = d;
    }
    public People(){
    }
}
public class MagicTower {
    public static int result = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int heroH = scanner.nextInt();
        int heroA = scanner.nextInt();
        int heroD = scanner.nextInt();
        People hero = new People(heroH,heroA,heroD);
        int totalMonsters = scanner.nextInt();
        People[] monsters = new People[totalMonsters];
        for(int i=0;i < totalMonsters;i ++){
            int monsterH = scanner.nextInt();
            int monsterA = scanner.nextInt();
            int monsterD = scanner.nextInt();
            monsters[i] = new People(monsterH,monsterA,monsterD);
        }
        fight(hero,monsters,0);
        System.out.println(result);
    }
    public static int fight(People hero,People monsters[],int index){
        if(hero.h <= 0 || index > monsters.length - 1){
            return result;
        }
        while (monsters[index].h > 0 && hero.h > 0){
            monsters[index].h -= Math.max((hero.a - monsters[index].d),1);
            hero.h -= Math.max((monsters[index].a - hero.d),1);
        }
        if(hero.h <=0 ){
            return result;
        }
        else {
            result++;
            return Math.max(Math.max(fight(new People(hero.h + 1000,hero.a,hero.d),monsters,index + 1),fight(new People(hero.h,hero.a + 10,hero.d),monsters,index + 1)),fight(new People(hero.h,hero.a,hero.d+10),monsters,index + 1));
        }
    }
}
