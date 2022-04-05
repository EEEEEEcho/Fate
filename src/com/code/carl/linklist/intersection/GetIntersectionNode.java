package com.code.carl.linklist.intersection;

import com.code.linkListTrain.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2){
            p1 = p1.next;
            if (p1 == null){
                p1 = headB;
            }
            p2 = p2.next;
            if (p2 == null){
                p2 = headA;
            }
        }
        return p1;
    }
}
