package com.labuladong.chapter1.linklist;

import com.code.link.ListNode;

public class ReverseBetween {
    ListNode successor = null;
    public ListNode reverseBetween(ListNode head, int left, int right){
        if (left == 1){
            //找到了要反转的起始位置
            return reverserN(head,right);
        }
        head.next = reverseBetween(head.next,left - 1,right - 1);
        return head;
    }
    //以head为头节点，反转前n个结点
    public ListNode reverserN(ListNode head,int n){
        if (n == 1){
            //找到了后继节点
            successor = head.next;
            return head;
        }
        ListNode last = reverserN(head.next,n - 1);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
