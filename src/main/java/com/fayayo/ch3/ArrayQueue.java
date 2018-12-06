package com.fayayo.ch3;

import com.fayayo.ch1.Array;

/**
 * @author dalizu on 2018/10/31.
 * @version v1.0
 * @desc 队列
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        this.array = new Array<E>(capacity);
    }

    public ArrayQueue() {
        this.array = new Array<E>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }


    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("Queue: ");
        res.append('[');
        for (int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i!=array.getSize()-1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer>arrayQueue=new ArrayQueue<>();

        for(int i=0;i<10;i++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if(i % 3 ==2){
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }

        }

    }

}
