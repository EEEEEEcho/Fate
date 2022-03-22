package com.code.EveryDay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {
    Node root;
    Map<String,Node> nodes; //保存字符串和它所在的结点的位置

    public AllOne(){
        root = new Node();
        root.prev = root;
        root.next = root; // 初始化链表哨兵，下面判断节点的 next 若为 root，则表示 next 为空（prev 同理）
        nodes = new HashMap<>();
    }
    public void inc(String key){
        if (nodes.containsKey(key)){
            //如果该字符串已经存在了，获取该字符串所在的结点
            Node cur = nodes.get(key);
            //获取当前结点的下一个结点
            Node next = cur.next;
            if(next == root || next.count > cur.count + 1){
                //如果下一个结点为空，或者下一个结点中字符串出现的次数比当前节点中字符串出现的次数要大2
                //那么就在当前结点之后新建一个结点，用来保存该字符串以及它出现的次数
                nodes.put(key,cur.insert(new Node(key,cur.count + 1)));
            }
            else{
                //否则的话，插入到下一个节点中
                next.keys.add(key);
                nodes.put(key,next);
            }
            //从当前节点中移除
            cur.keys.remove(key);
            if (cur.keys.isEmpty()){
                cur.remove();
            }
        }
        else {
            //key不在链表中
            if (root.next == root || root.next.count > 1){
                //如果当前链表为空或者当前链表中所有字符串出现的次数都大于1
                //在root后面新建一个结点
                nodes.put(key,root.insert(new Node(key,1)));
            }
            else{
                root.next.keys.add(key);
                nodes.put(key,root.next);
            }
        }
    }

    public void dec(String key){
        //获取该字符串所在的node结点
        Node cur = nodes.get(key);
        if (cur.count == 1){
            //如果该结点只出现过一次,从hash表中删掉
            nodes.remove(key);
        }
        else{
            //获取前一个结点
            Node pre = cur.prev;
            if (pre == root || pre.count < cur.count - 1){
                //如果前面的结点为空。或者前面结点中字符串的出现次数，比该字符串出现次数减去一还要小，那么就新建一个结点
                nodes.put(key,cur.prev.insert(new Node(key,cur.count - 1)));
            }
            else{
                pre.keys.add(key);
                nodes.put(key,pre);
            }
        }
        cur.keys.remove(key);
        if (cur.keys.isEmpty()){
            cur.remove();
        }
    }
    public String getMaxKey(){
        return root.prev != null ? root.prev.keys.iterator().next() : "";
    }
    public String getMinKey(){
        return root.next != null ? root.next.keys.iterator().next() : "";
    }
}
class Node{
    Node prev;
    Node next;
    Set<String> keys;//保存所有出现次数相同的字符串的结点
    int count;  //这是该节点的所有字符串的出现次数
    public Node(){
        this("",0);
    }
    public Node(String key,int count){
        this.count = count;
        keys = new HashSet<>();
        keys.add(key);
    }

    public Node insert(Node node){
        //在this之后插入node
        node.prev = this;
        node.next = this.next;
        this.next.prev = node;
        this.next = node;
        return node;
    }

    public void remove(){
        //删除this，即当前结点
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }

}
