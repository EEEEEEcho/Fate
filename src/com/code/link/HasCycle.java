package com.code.link;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    //笨方法
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
    //快慢指针
    //判断链表是否包含环属于经典问题了，解决方案也是用快慢指针：
    //每当慢指针 slow 前进一步，快指针 fast 就前进两步。
    //如果 fast 最终遇到空指针，说明链表中没有环；如果 fast 最终和 slow 相遇，
    //那肯定是 fast 超过了 slow 一圈，说明链表中含有环。
    //只需要把寻找链表中点的代码稍加修改就行了：
    public boolean hasCycle2(ListNode head){
        ListNode slow = head;   //慢针
        ListNode fast = head;   //快针

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                //如果快针和慢针相遇，证明有环
                return true;
            }
        }
        return false;
    }
}
