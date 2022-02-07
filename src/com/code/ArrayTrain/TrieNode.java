package com.code.ArrayTrain;

/**
 * 前缀树节点
 */
public class TrieNode{
    int count;  //以当前单词结尾的单词数量
    int prefix; //以该处节点之前的字符串为前缀的单词数量
    TrieNode[] nextNode = new TrieNode[26]; //因为可能出现26个字母
    public TrieNode(){
        count = 0;
        prefix = 0;
    }
}