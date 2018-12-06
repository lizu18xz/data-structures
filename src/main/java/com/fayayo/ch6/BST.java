package com.fayayo.ch6;

/**
 * @author dalizu on 2018/12/6.
 * @version v1.0
 * @desc 二分搜索树  Comparable  具有可比较性
 */
public class BST <E extends Comparable<E>>{


    private class Node{
        public E e;
        public Node left,right;
        public Node(E e) {
            this.e = e;
            left=null;
            right=null;
        }
    }


    private Node root;//根节点
    private int size;//元素个数

    public BST() {
        root=null;
        size=0;
    }


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //添加元素
    public void add(E e){
        if(root == null){
            root = new Node(e);
            size++;
        }else {
            add(root,e);
        }

    }

    //向以node为根的二分搜索树中添加元素E,递归算法
    private void add(Node node,E e){

        //终止条件
        if(e.equals(node.e)){
            return;
        }else if(e.compareTo(node.e)<0 && node.left==null){//小于
            node.left=new Node(e);
            size++;
            return;
        }else if(e.compareTo(node.e)>0 && node.right==null){
            node.right=new Node(e);
            size++;
            return;
        }

        //递归操作
        if(e.compareTo(node.e)<0){
            add(node.left,e);
        }else {
            add(node.right,e);
        }


    }



}
