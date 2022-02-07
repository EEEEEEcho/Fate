package com.labuladong.chapter1.linklist;

import com.code.link.ListNode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length,(a,b) -> a.val - b.val);
        for (ListNode node : lists) if(node != null) priorityQueue.add(node);
        while (!priorityQueue.isEmpty()){
            ListNode node = priorityQueue.poll();
            p.next = node;
            if (node.next != null){
                priorityQueue.add(node.next);
            }
            p = p.next;
        }
        return head.next;
    }
}
