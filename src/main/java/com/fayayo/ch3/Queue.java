package com.fayayo.ch3;

/**
 * @author dalizu on 2018/10/31.
 * @version v1.0
 * @desc
 */
public interface Queue<E> {


    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();


}
