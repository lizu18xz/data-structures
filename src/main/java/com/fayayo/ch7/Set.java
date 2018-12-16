package com.fayayo.ch7;

/**
 * @author dalizu on 2018/12/16.
 * @version v1.0
 * @desc
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
