package com.code.linkListTrain;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        head.next = l1;
//        while (l1 != null){
//            if (l2.val >= l1.val){
//                ListNode tmp = l2;
//                l2 = l2.next;
//                tmp.next = l1.next;
//                l1.next = tmp;
//                l1 = tmp.next;
//            }
//            else{
//                l1 = l1.next;
//            }
//        }
        while (head.next != null){
            ListNode n = head.next;
            if (l2 == null){
                break;
            }
            if (l2.val >= n.val){
                ListNode tmp = l2;
                l2 = l2.next;
                tmp.next = n.next;
                n.next = tmp;
                head = tmp;
            }
            else{
                head = head.next;
            }
            if (l2 != null){
                head.next = l2;
            }
        }
        return l1;
    }
}
