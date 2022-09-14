package com.interview.wm;

import com.demo.Main;

import java.util.*;

public class Main1 {
    public static class Item{
        public final String name;
        public int num;

        public Item(String name,int num) {
            this.name = name;
            this.num = num;
        }

        @Override
        public String toString(){
            return "[" + name + "," + num + "]";
        }
    }

    public List<Item> tryAddAndPack(List<Item> itemList, List<Item> itemAddList, Map<String, Integer> confMap, int capacity) {
        //TODO
        //1.先整理现有道具
        TreeMap<String,Item> bag = new TreeMap<>();
        for (Item item : itemList) {
            if (bag.containsKey(item.name)) {
                bag.get(item.name).num += item.num;
            } else {
                bag.put(item.name, item);
            }
        }
        //2.备份后的整理的道具
        TreeMap<String,Item> backUp = new TreeMap<>();
        for (Map.Entry<String,Item> entry : bag.entrySet()){
            backUp.put(entry.getKey(),new Item(entry.getKey(),entry.getValue().num));
        }
        //2.计算可用容量
        int canUse = capacity - bag.size();
        //3.开始添加道具
        for (Item item : itemAddList){
            //如果背包里已经有该种道具了
            if (bag.containsKey(item.name)){
                Item exist = bag.get(item.name);
                //计算添加该道具之后的容量
                int total = exist.num + item.num;
                //判断添加之后的容量是否合法
                if (confMap.containsKey(item.name) && total <= confMap.get(item.name)){
                    exist.num += item.num;
                }
                else {
                    if (canUse > 0){
                        exist.num += item.num;
                        canUse --;
                    }
                    else {
                        return map2List(backUp, confMap);
                    }
                }
            }
            else {
                if (canUse <= 0) return map2List(backUp, confMap);
                if (confMap.containsKey(item.name) && item.num <= confMap.get(item.name)){
                    bag.put(item.name,item);
                    canUse --;
                }
                else {
                    return map2List(backUp, confMap);
                }
            }
        }
        return map2List(bag,confMap);
    }

    public List<Item> map2List(TreeMap<String,Item> map,Map<String,Integer> confMap){
        List<Item> list = new ArrayList<>();
        for (Map.Entry<String,Item> entry : map.entrySet()){
            Item item = entry.getValue();
            int confValue = confMap.get(item.name);
            if (item.num > confValue){
                int num2put = item.num / confValue;
                int left2put = item.num % confValue;
                for (int i = 0; i < num2put; i++) {
                    list.add(new Item(item.name,confValue));
                }
                list.add(new Item(item.name,left2put));
            }
            else {
                list.add(entry.getValue());
            }

        }
        return list;
    }

    public static void main(String[] args) {
        Main1 main1 = new Main1();
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("A",1));
        itemList.add(new Item("B",3));
        itemList.add(new Item("A",2));
        List<Item> itemAddList = new ArrayList<>();
        itemAddList.add(new Item("A",5));
        itemAddList.add(new Item("B",10));
        Map<String ,Integer> confMap = new HashMap<>();
        confMap.put("A",10);
        confMap.put("B",10);
        List<Item> itemList1 = main1.tryAddAndPack(itemList, itemAddList, confMap, 3);
        System.out.println(itemList1);
    }
}
