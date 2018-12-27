package com.fayayo.ch8;

/**
 * @author dalizu on 2018/12/25.
 * @version v1.0
 * @desc 最大堆
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<E>(capacity);
    }

    public MaxHeap() {
        data = new Array<E>();
    }


    //Heapify
    public MaxHeap(E[]arr){
        data=new Array<E>(arr);
        for (int i=parent(arr.length-1);i>=0;i--){
            siftDown(i);
        }
    }

    //返回堆中元素个数
    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {

        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {

        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);

        siftUp(data.getSize() - 1);

    }

    private void siftUp(int k) {
        //比較k元素和父亲元素,如果父亲元素小，则上浮k元素
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }

    }


    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    //取出堆中最大的元素
    public E extractMax() {

        E ret = findMax();//保存最大堆

        //先交换位置,最大的元素先交换到最后，然后删除
        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()) {

            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);//data.get(j + 1)
            }
            //data[j]是左孩子和右孩子中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }

    }


    //取出堆中最大值，并替换为元素e
    public E replace(E e){

        E ret=findMax();

        data.set(0,e);

        siftDown(0);

        return ret;

    }



}
