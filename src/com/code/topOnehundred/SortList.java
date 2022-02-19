package com.code.topOnehundred;

import java.util.PriorityQueue;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        ListNode res = sentinel;
        sentinel.next = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1,node2) -> node1.val - node2.val);
        while (head != null){
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
            pq.add(tmp);
        }
        while (!pq.isEmpty()){
            sentinel.next = pq.poll();
            sentinel = sentinel.next;
        }
        return res.next;
    }

    //自顶向下的归并排序
    public ListNode sortList1(ListNode head){
        return sort(head,null);
    }
    public ListNode sort(ListNode head,ListNode tail){
        //1.基础条件：如果head为null那么返回null
        if (head == null){
            return null;
        }
        //2.如果这个链表只有两个元素,或者是一个 3 -> null 类型的链表。返回头部
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode l1 = sort(head,mid);
        ListNode l2 = sort(mid,tail);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode yummy = new ListNode(-1);
        ListNode ans = yummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                yummy.next = l1;
                l1 = l1.next;
            }
            else {
                yummy.next = l2;
                l2 = l2.next;
            }
            yummy = yummy.next;
        }
        while (l1 != null){
            yummy.next = l1;
            l1 = l1.next;
            yummy = yummy.next;
        }
        while (l2 != null){
            yummy.next = l2;
            l2 = l2.next;
            yummy = yummy.next;
        }
        return ans.next;
    }


    public static void main(String[] args) {
        SortList s = new SortList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        s.sortList(n1);
    }
}
