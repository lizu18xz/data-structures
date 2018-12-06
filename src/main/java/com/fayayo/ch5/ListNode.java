package com.fayayo.ch5;

/**
 * @author dalizu on 2018/11/15.
 * @version v1.0
 * @desc
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    //链表节点的构造函数，创建链表
    public ListNode(int arr[]){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr can not be empty");
        }

        this.val=arr[0];
        ListNode cur=this;
        for(int i=1;i<arr.length;i++){
            cur.next=new ListNode(arr[i]);
            cur=cur.next;
        }
    }


    @Override
    public String toString() {

        StringBuilder stringBuilder=new StringBuilder();
        ListNode cur=this;
        while (cur!=null){
            stringBuilder.append(cur.val+"->");
            cur=cur.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

}
