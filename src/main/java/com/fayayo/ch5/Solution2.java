package com.fayayo.ch5;

/**
 * @author dalizu on 2018/11/15.
 * @version v1.0
 * @desc 虚拟节点
 */
public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;

        //从第一个元素之前的元素
        ListNode prev=dummyHead;
        while (prev.next !=null){
            if(prev.next.val == val){
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }else {
                prev=prev.next;
            }
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {

        int[] nums={1,2,6,3,4,5,6};


        ListNode listNode=new ListNode(nums);

        System.out.println(listNode);

        ListNode res=new Solution2().removeElements(listNode,6);

        System.out.println(res);

    }

}
