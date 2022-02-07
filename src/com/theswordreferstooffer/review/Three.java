package com.theswordreferstooffer.review;

import java.util.ArrayList;

public class Three {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ListNode head = new ListNode(-1);
//        head.next = null;
//        ListNode tmp = null;
//        while (listNode != null){
//            //创建新节点 不能直接tmp = listNode 否则下一步会使得tmp.next = head.next 使得 listNode.next 成为null
//            tmp = new ListNode(listNode.val);
//            tmp.next = head.next;
//            head.next = tmp;
//            listNode = listNode.next;
//        }
//        ListNode p = head.next;
        //倒叙重组链表
        ListNode pre = null;
        ListNode curr = listNode;
        while (curr != null){
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        ListNode p = pre;
        ArrayList<Integer> list = new ArrayList<>();
        while (p != null){
            list.add(p.val);
            p = p.next;
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode f = new ListNode(1);
        ListNode s = new ListNode(2);
        f.next = s;
        Three t = new Three();
        System.out.println(t.printListFromTailToHead(f));
    }
}
