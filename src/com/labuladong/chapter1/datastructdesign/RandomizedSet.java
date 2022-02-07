package com.labuladong.chapter1.datastructdesign;

import java.util.*;

public class RandomizedSet {
    ArrayList<Integer> values;
    HashMap<Integer,Integer> v2Index;
    Random random;
    public RandomizedSet() {
        values = new ArrayList<>();
        v2Index = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        //如果已经存在该元素了，那么就返回false
        if (v2Index.containsKey(val)) return false;
        //否则插入到数组的最末尾
        v2Index.put(val,values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        //如果不存在，返回false
        if (!v2Index.containsKey(val)) return false;
        //存在，找到元素的位置
        int pos = v2Index.get(val);
        //将最后一个元素，换到他的位置
        int lastNum = values.get(values.size() - 1);
        values.set(pos,lastNum);
        values.remove(values.size() - 1);
        v2Index.put(lastNum,pos);
        v2Index.remove(val);
        return true;
    }

    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}
