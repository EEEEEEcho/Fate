package com.theswordreferstooffer.offer;

public class MergeSortedList {
    /**
     * 我自己写的，太冗杂
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode pre = null;
        ListNode p1 = list1;
        ListNode p2 = list2;
        if(p1 != null && p2 != null){
            if (p1.val <= p2.val) {
                pre = p1;
                p1 = p1.next;
            } else {
                pre = p2;
                p2 = p2.next;
            }
        }
        ListNode head = pre;
        //System.out.println(head.val);
        while (p1 != null && p2 != null) {
            while (p1 != null && p2 != null && p1.val <= p2.val) {
                pre.next = p1;
                pre = p1;
                //System.out.println(pre.val);
                p1 = p1.next;
            }
            while (p1 != null && p2 != null && p2.val < p1.val) {
                pre.next = p2;
                pre = p2;
                //System.out.println(pre.val);
                p2 = p2.next;
            }
        }
        while (p1!=null){
            pre.next = p1;
            pre = p1;
            p1 = p1.next;
        }
        while (p2 != null){
            pre.next = p2;
            pre = p2;
            p2 = p2.next;
        }
        return head;
    }

    /**
     * 书上的
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge2(ListNode list1, ListNode list2){
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                pre.next = list1;
                list1 = list1.next;
            }
            else{
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null? list2 : list1;
        return preHead.next;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        node4.next = node5;
        node5.next = node6;
        MergeSortedList m = new MergeSortedList();
        ListNode result = m.Merge(node1,null);
        while (result != null ){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
