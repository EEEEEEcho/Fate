package com.code.codertop;


import com.code.link.ListNode;

import java.util.ArrayList;
import java.util.Collections;

public class SortList {
    public ListNode sortList1(ListNode head) {
        if (head == null) return head;
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null){
            arrayList.add(tmp.val);
            tmp = tmp.next;
        }
        Collections.sort(arrayList);
        int i = 0;
        ListNode ans = head;
        while (head != null){
            head.val = arrayList.get(i++);
            head = head.next;
        }
        return ans;
    }

    //归并排序
    public ListNode sortList(ListNode head) {
        return sort(head,null);
    }

    public ListNode sort(ListNode head,ListNode tail){
        if (head == null){
            return head;
        }
        //对半分
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        //找head和tail之间的中点
        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode left = sort(head,mid);
        ListNode right = sort(mid,tail);
        return merge(left,right);
    }

    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }
            else{
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }

        while (l1 != null){
            tmp.next = l1;
            l1 = l1.next;
            tmp = tmp.next;
        }

        while (l2 != null){
            tmp.next = l2;
            l2 = l2.next;
            tmp = tmp.next;
        }

        return dummy.next;
    }
}
