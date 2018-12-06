package com.fayayo.ch2;


import java.util.Random;

/**
 * @author dalizu on 2018/10/25.
 * @version v1.0
 * @desc 比较 数组栈和链表栈
 */
public class Main {

    public static double testStack(Stack<Integer>stack,int opCount){

        long startTime=System.nanoTime();

        Random random=new Random();

        for (int i =0; i <opCount;i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i =0; i <opCount;i++){
            stack.pop();
        }

        long endTime=System.nanoTime();


        return (endTime - startTime) / 1000000000.0;//纳秒和秒

    }

    public static void main(String[] args) {

        int opCount=10000000;

        ArrayStack<Integer>arrayStack=new ArrayStack<>();
        double time1=testStack(arrayStack,opCount);
        System.out.println("ArrayStack,time: "+time1+" s");

        LinkListStack<Integer>linkListStack=new LinkListStack<>();
        double time2=testStack(linkListStack,opCount);
        System.out.println("linkListStack,time: "+time2+" s");

    }

}
