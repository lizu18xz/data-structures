package com.fayayo.ch2;

/**
 * @author dalizu on 2018/10/25.
 * @version v1.0
 * @desc 栈接口
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();


}
