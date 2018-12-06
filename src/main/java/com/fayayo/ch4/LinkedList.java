package com.fayayo.ch4;

/**
 * @author dalizu on 2018/11/4.
 * @version v1.0
 * @desc
 */
public class LinkedList<E> {


    private class Node {

        public E e;//存放的元素

        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node dummyHead;

    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);//虚拟头节点
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在链表头添加元素
    public void addFirst(E e) {
        /*Node node=new Node(e);
        node.next=head;
        head=node;*/
        add(0,e);
    }

    //在链表index(0-based)位置添加新的元素e  在链表中不是一个常用的操作
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;//找到带插入节点前面的节点
        }
        /*Node node=new Node(e);
          node.next=prev.next;
          prev.next=node;*/
        prev.next = new Node(e, prev.next);//替代上面三句话
        size++;
    }

    //在链表末尾添加新的元素
    public void addLast(E e) {
        add(size, e);
    }

    //获取链表第index个的位置(不常用的操作)
    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }

    //获取链表的第一个元素
    public E getFirst(){
        return get(0);
    }


    //获取链表的最后一个元素
    public E getLast(){
        return get(size-1);
    }

    //修改链表的元素，不常用
    public void set(int index,E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node cur=dummyHead.next;

        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.e=e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e){

        Node cur=dummyHead.next;

        while (cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }


    //删除操作(不常用)
    public E remove(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        Node prev=dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }

        Node retNode=prev.next;
        prev.next=retNode.next;
        retNode.next=null;

        size--;

        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }


    @Override
    public String toString() {

        StringBuilder  res=new StringBuilder();

        Node cur=dummyHead.next;
        while (cur !=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
