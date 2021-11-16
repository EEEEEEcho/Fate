package com.code.linkListTrain;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {
    //笨方法一
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
    //笨方法二，找出那个长的
    public ListNode getIntersectionNode2(ListNode headA,ListNode headB){
        int aLength = 0;
        int bLength = 0;
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA != null){
            aLength ++;
            tmpA = tmpA.next;
        }
        while (tmpB != null){
            bLength ++;
            tmpB = tmpB.next;
        }
        int step = 0;
        if (aLength >= bLength){
            step = aLength - bLength;
            while (step > 0){
                headA = headA.next;
                step --;
            }
        }
        else{
            step = bLength - aLength;
            while (step > 0){
                headB = headB.next;
                step --;
            }
        }
        while (headA != null && headB != null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    //丝滑小连招
    //如果用两个指针 p1 和 p2 分别在两条链表上前进，并不能同时走到公共节点，也就无法得到相交节点 c1。
    //所以，解决这个问题的关键是，通过某些方式，让 p1 和 p2 能够同时到达相交节点 c1。
    //所以，我们可以让 p1 遍历完链表 A 之后开始遍历链表 B，让 p2 遍历完链表 B 之后开始遍历链表 A，这样相当于「逻辑上」两条链表接在了一起。
    //如果这样进行拼接，就可以让 p1 和 p2 同时进入公共部分，也就是同时到达相交节点 c1：
    public ListNode getIntersectionNode3(ListNode headA,ListNode headB){
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2){
            if (p1 == null) p1 = headB;
            else  p1 = p1.next;

            if (p2 == null) p2 = headA;
            else  p2 = p2.next;
        }
        return p1;
    }
}
