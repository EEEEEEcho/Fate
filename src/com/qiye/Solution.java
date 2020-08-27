package com.qiye;

import java.util.Scanner;

class ListNode{
    int val;
    ListNode next = null;
}
public class Solution {
    public ListNode reverseLinkList(ListNode root){
        ListNode first = root.next;
        root.next = null;
        while (first != null){
            ListNode tmp = first;
            first = first.next;
            tmp.next = root.next;
            root.next = tmp;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode root = new ListNode();
        ListNode head = root;
        int n = scanner.nextInt();
        for(int i=0;i < n;i ++){
            ListNode node = new ListNode();
            node.val = scanner.nextInt();
            head.next = node;
            head = node;
        }
        ListNode ind = new Solution().reverseLinkList(root).next;
        while (ind != null){
            System.out.print(ind.val + " ");
            ind = ind.next;
        }
    }
}
