package com.fayayo.ch8;

/**
 * @author dalizu on 2018/12/25.
 * @version v1.0
 * @desc 优先队列
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{

    private MaxHeap<E>maxHeap;

    public PriorityQueue() {
        this.maxHeap = new MaxHeap<E>();
    }

    //入队
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    //出队
    @Override
    public E dequeue() {
        //每次返回最大的
        return maxHeap.extractMax();
    }

    //队首元素
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
