package com.fayayo.ch7_2;

/**
 * @author dalizu on 2018/12/18.
 * @version v1.0
 * @desc 映射
 */
public interface Map<K,V> {

    void add(K key,V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key,V newValue);

    int getSize();

    boolean isEmpty();

}
