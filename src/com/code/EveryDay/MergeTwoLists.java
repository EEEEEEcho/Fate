package com.code.EveryDay;

public class MergeTwoLists {
    //不节省空间
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode ans = head;
        while (l1 != null && l2 != null){
            ListNode node = new ListNode();
            if (l1.val <= l2.val){
               node.val = l1.val;
               l1 = l1.next;
            }
            else{
                node.val = l2.val;
                l2 = l2.next;
            }
            head.next = node;
            head = head.next;
        }
        while (l1 != null){
            ListNode node = new ListNode(l1.val);
            head.next = node;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null){
            ListNode node = new ListNode(l2.val);
            head.next = node;
            head = head.next;
            l2 = l2.next;
        }
        return ans.next;
    }
    //节省空间法,断指针而非开空间
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode ans = head;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next;
            }
            else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        while (l1 != null){
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }
        while (l2 != null){
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        return ans.next;
    }
}
