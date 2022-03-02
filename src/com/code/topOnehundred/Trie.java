package com.code.topOnehundred;

public class Trie {
    static class TrieNode{
        public boolean isEnd;   //该节点是否为终端节点
        public TrieNode[] next;    //该节点的后续节点
        public TrieNode(){
            isEnd = false;
            next = new TrieNode[26];
        }
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        //构造指向root的指针
        TrieNode node = root;
        char[] chars = word.toCharArray();
        //遍历word
        for (int i = 0; i < chars.length; i++) {
            //如果node的下一个该字母的节点为空，那么创建一个新的节点
            if (node.next[chars[i] - 'a'] == null){
                node.next[chars[i] - 'a'] = new TrieNode();
            }
            //否则向下遍历
            node = node.next[chars[i] - 'a'];
        }
        //遍历到最后一个字母节点是单词的末尾
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()){
            if (node.next[c - 'a'] == null){
                return false;
            }
            node = node.next[c - 'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()){
            if (node.next[c - 'a'] == null){
                return false;
            }
            node = node.next[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        trie.startsWith("app");
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
