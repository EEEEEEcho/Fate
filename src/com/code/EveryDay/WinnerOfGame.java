package com.code.EveryDay;

public class WinnerOfGame {
    public boolean winnerOfGame(String colors) {
        //我的脑筋不会急转弯。。。
        //谁能删的多，谁获胜
        if(colors.length() <= 2){
            return false;
        }
        int alice = 0;
        int bob = 0;
        for (int i = 1; i <= colors.length() - 2; i++) {
            if(colors.charAt(i - 1) == 'A' && colors.charAt(i) == 'A' && colors.charAt(i + 1) =='A') alice ++;
            if (colors.charAt(i - 1) == 'B' && colors.charAt(i) == 'B' && colors.charAt(i + 1) =='B') bob ++;
        }
        return alice > bob;
    }
}
