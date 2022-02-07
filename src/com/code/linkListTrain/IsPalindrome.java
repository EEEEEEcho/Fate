package com.code.linkListTrain;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找回文串是从中间向两端扩展，判断回文串是从两端向中间收缩
 */
public class IsPalindrome {
    //最丑的办法
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i <= j){
            if (list.get(i) != list.get(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //链表的遍历方法
    public void lookUp(ListNode node){
        //前序遍历 visit(node)
        lookUp(node.next);
        //后续遍历 visit(node)
    }

    ListNode left;
    //前序后序结合的方法来判断是否回文
    public boolean isPalindrome1(ListNode head){
        left = head;
        return traverse(head);
    }

    public boolean traverse(ListNode right){
        if (right == null) return true;
        boolean res = traverse(right.next);
        //后序遍历
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }

    //找中点，翻转后面的部分，然后判断
    public boolean isPalindrome2(ListNode head){
        ListNode slow = head,fast = head;
        //找中点
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //奇数链
        if (fast != null){
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null){
            if (left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null,cur = head,nxt = head;
        while (cur != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }


    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        int i = 0;
        int j = l.size() - 1;
        while (i <= j){
            System.out.println(l.get(i));
            System.out.println(l.get(j));
            i ++;
            j --;
        }
    }
}
