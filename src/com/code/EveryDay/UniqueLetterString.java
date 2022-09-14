package com.code.EveryDay;

import java.util.*;

public class UniqueLetterString {
    public int uniqueLetterString(String s) {
        Map<Character,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c,new ArrayList<>());
                //第一次出现的位置是 -1?
                map.get(c).add(-1);
            }
            map.get(c).add(i);
        }

        int count = 0;
        for (Map.Entry<Character,List<Integer>> entry : map.entrySet()){
            List<Integer> entryValue = entry.getValue();
            //最后出现的位置？
            entryValue.add(s.length());
            for (int i = 1; i < entryValue.size() - 1; i++) {
                count += (entryValue.get(i) - entryValue.get(i - 1)) * (entryValue.get(i + 1) - entryValue.get(i));
            }
        }
        return count;
    }

    public int getLetterCount(String s){
        int[] marked = new int[26];
        for (int i = 0; i < s.length(); i++) {
            marked[s.charAt(i) - 'A'] ++;
        }
        return (int) Arrays.stream(marked).filter(i -> i == 1).count();
    }

    public static void main(String[] args) {
        UniqueLetterString uniqueLetterString = new UniqueLetterString();
        int abc = uniqueLetterString.uniqueLetterString("DELQGVWNZKIJJPSXOVWWIZUXCEGWSQLESNSRBMKZARFPAXSVWQEZDENDAHNNIBHGHTFDLPGDLFXMIYRFNLMXHNPIFUAXINXPXLCTTJNLGGMKJIOEWBECNOFQPVCIKIAZMNGHEHFMCPWSMJTMGVSXTOGCGUYKFMNCGLCBRAFJLJVPIVDOLJBURULPGXBVDCEWXXXLTRMSHPKSPFDGNVOCZWDXJUWVNAREDOKTZMIUDKDQWWWSAEUUDBHMWZELOSBIHMAYJEMGZPMDOOGSCKLVHTGMETHUISCLJKDOQEWGVBULEMUXGTRKGXYFDIZTZWMLOFTCANBGUARNWQEQWGMIKMORVQUZANJNRNPMJWYLVHWKDFLDDBBMILAKGFROEQAMEVONUVHOHGPKLBPNYZFPLXNBCIFENCGIMIDCXIIQJWPVVCOCJTSKSHVMQJNLHSQTEZQTTMOXUSKBMUJEJDBJQNXECJGSZUDENJCPTTSREKHPRIISXMWBUGMTOVOTRKQCFSDOTEFPSVQINYLHXYVZTVAMWGPNKIDLOPGAMWSKDXEPLPPTKUHEKBQAWEBMORRZHBLOGIYLTPMUVBPGOOOIEBJEGTKQKOUURHSEJCMWMGHXYIAOGKJXFAMRLGTPNSLERNOHSDFSSFASUJTFHBDMGBQOKZRBRAZEQQVWFRNUNHBGKRFNBETEDJIWCTUBJDPFRRVNZENGRANELPHSDJLKVHWXAXUTMPWHUQPLTLYQAATEFXHZARFAUDLIUDEHEGGNIYICVARQNRJJKQSLXKZZTFPVJMOXADCIGKUXCVMLPFJGVXMMBEKQXFNXNUWOHCSZSEZWZHDCXPGLROYPMUOBDFLQMTTERGSSGVGOURDWDSEXONCKWHDUOVDHDESNINELLCTURJHGCJWVIPNSISHRWTFSFNRAHJAJNNXKKEMESDWGIYIQQRLUUADAXOUEYURQRVZBCSHXXFLYWFHDZKPHAGYOCTYGZNPALAUZSTOU");
        System.out.println(abc);
    }
}
