package com.fayayo.ch5;

/**
 * @author dalizu on 2018/11/15.
 * @version v1.0
 * @desc 递归
 */
public class Solution3 {


    public ListNode removeElements(ListNode head, int val) {

        //最基本情况
        if(head==null){
            return null;
        }

        ListNode res=removeElements(head.next,val);//想象成一个功能

        //完成后
        if(head.val==val){
            return res;
        }else {
            head.next = res;
            return head;
        }

    }

    public static void main(String[] args) {

        int[] nums={1,2,6,3,4,5,6};


        ListNode listNode=new ListNode(nums);

        System.out.println(listNode);

        ListNode res=new Solution3().removeElements(listNode,6);

        System.out.println(res);

    }

}
