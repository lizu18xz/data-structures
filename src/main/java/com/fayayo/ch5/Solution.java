package com.fayayo.ch5;

/**
 * @author dalizu on 2018/11/15.
 * @version v1.0
 * @desc 移除链表元素
 * 输入: 1->2->6->3->4->5->6, val = 6
   输出: 1->2->3->4->5
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {

        while(head !=null && head.val == val){
            ListNode delNode=head;
            head = head.next;
            delNode=null;
        }

        if(head == null){
            return null;
        }

        ListNode prev=head;
        while (prev.next !=null){
            if(prev.next.val == val){
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }else {
                prev=prev.next;
            }
        }

        return head;
    }


}
