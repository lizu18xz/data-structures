package com.fayayo.ch3;

import java.util.Arrays;

/**
 * @author dalizu on 2018/10/31.
 * @version v1.0
 * @desc 循环队列
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front,tail;

    private int size;//队列中元素的个数

    public LoopQueue(int capacity) {
        data= (E[]) new Object[capacity+1];//会多加一个元素
        front=0;
        tail=0;
        size=0;
    }

    public LoopQueue() {
        this(10);
    }

    //入队  [] [] [] [] [] [] []
    @Override
    public void enqueue(E e) {

        if((tail + 1) % data.length == front ){
            resize(getCapacity() * 2);
        }

        data[tail] =e;
        tail=(tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i=0;i<size;i++){
            newData[i] = data[(i+front) % data.length];
        }

        data=newData;
        front=0;
        tail=size;
    }

    @Override
    public E dequeue() {

        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E ret= data[front];
        data[front] = null;
        front=(front + 1) % data.length;
        size--;
        if(size == getCapacity() / 4 && getCapacity() /2 !=0){
            resize(getCapacity() /2);
        }

        return ret;
    }

    @Override
    public E getFront() {

        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity(){
        return data.length-1;
    }


    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("LoopQueue :size= %d,capacity= %d\n",size,getCapacity()));
        res.append("front [");

        for (int i=front;i!=tail;i=(i+1) % data.length){
            res.append(data[i]);
            if((i+1) % data.length !=tail){
                res.append(", ");
            }
        }

        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer>loopQueue=new LoopQueue<>();

        for(int i=0;i<10;i++){
            loopQueue.enqueue(i);
            System.out.println(loopQueue);

            if(i % 3 ==2){
                loopQueue.dequeue();
                System.out.println(""+loopQueue);
            }

        }

    }

}