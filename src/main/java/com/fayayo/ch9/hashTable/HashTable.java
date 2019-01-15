package com.fayayo.ch9.hashTable;

import java.util.TreeMap;

/**
 * @author dalizu on 2019/1/8.
 * @version v1.0
 * @desc 均摊复杂度O(1)   性能提升了但是牺牲了顺序性
 */
public class HashTable<K, V> {

    //素数表  保证分布均匀
    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};


    private static final int upperTol = 10;

    private static final int lower = 2;

    private int capacityIndex = 0;

    private TreeMap<K, V>[] hasttable;

    //hash表的长度
    private int M;

    private int size;


    public HashTable() {
        this.M = capacity[capacityIndex];
        size = 0;

        hasttable = new TreeMap[M];

        for (int i = 0; i < M; i++) {
            hasttable[i] = new TreeMap<K, V>();
        }
    }


    private int hash(K key) {

        //先会转为整形 去掉符合(整形和31个1 & ,最高位变为0)  转为我们数组里面的某个索引
        return (key.hashCode() & 0x7fffffff) % M;
    }


    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hasttable[hash(key)];
        //已经包含了
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            //真正添加
            map.put(key, value);
            size++;
            if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
    }


    public V remove(K key) {
        TreeMap<K, V> map = hasttable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {

            ret = map.remove(key);
            size--;

            if (size < lower * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }

        return ret;
    }


    public void set(K key, V value) {
        TreeMap<K, V> map = hasttable[hash(key)];

        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        map.put(key, value);

    }

    public boolean contains(K key) {
        return hasttable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        TreeMap<K, V> map = hasttable[hash(key)];
        return map.get(key);
    }


    //扩容
    private void resize(int newM) {

        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<K, V>();
        }

        int oldM = M;
        this.M = newM;
        //取出原来所有的元素，重新放入新的地方
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hasttable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }

        this.hasttable = newHashTable;
    }
}
