package com.code.EveryDay;

import java.util.PriorityQueue;

public class MergeKLists {
    //笨方法，两条两条合并。
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return new ListNode();
        }
        ListNode first = lists[0];
        for (int i = 1; i < lists.length; i++) {
            first = merge(first,lists[i]);
        }
        return first;
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode head = new ListNode();
        ListNode ans = head;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
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
    //好方法，将链表的节点放入堆中（这里堆的实现是优先队列），每次选取最小的节点，
    //这里有一个总结是：如果遇到类似，每次循环都想获得某一序列中的最小值的时候，可以考虑将序列中的
    //所有最小值放入到一个堆中
    public ListNode mergeKLists2(ListNode[] lists){
        if(lists.length == 0) return null;
        ListNode head = new ListNode(-1);
        ListNode ans = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,
                (node1,node2) -> {return node1.val - node2.val;});
        for(ListNode node : lists){
            if (node != null){
                pq.add(node);
            }
        }
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            head.next = node;
            if (node.next != null){
                pq.add(node.next);
            }
            head = head.next;
        }
        return ans.next;
    }

}
