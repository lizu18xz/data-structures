package com.fayayo.ch2;

import com.fayayo.ch4.LinkedList;

/**
 * @author dalizu on 2018/11/15.
 * @version v1.0
 * @desc 链表栈
 */
public class LinkListStack<E> implements Stack<E> {

    private LinkedList<E>list;//链表

    public LinkListStack() {
        list = new LinkedList<E>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {

        list.addFirst(e);

    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }


    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {

        LinkListStack<Integer>stack=new LinkListStack<>();

        for (int i=0;i<5;i++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

    }

}
