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





}
