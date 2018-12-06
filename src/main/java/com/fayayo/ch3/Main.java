package com.fayayo.ch3;

import com.fayayo.ch1.Array;

import java.util.Random;

/**
 * @author dalizu on 2018/10/31.
 * @version v1.0
 * @desc 测试比较 ArrayQueue,time: 3.339502712 s  LoopQueue,time: 0.011293752 s
 */
public class Main {

    //运行入队 出队 所需要的时间  单位:秒
    private static double testQueue(Queue<Integer>q,int opCount){

        long startTime=System.nanoTime();

        Random random=new Random();

        for (int i =0; i <opCount;i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i =0; i <opCount;i++){
            q.dequeue();
        }

        long endTime=System.nanoTime();


        return (endTime - startTime) / 1000000000.0;//纳秒和秒
    }

    public static void main(String[] args) {
        //比较 ArrayQueue 和 LoopQueue
        int opCount=100000;

        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();

        double time1=testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue,time: "+time1+" s");


        LoopQueue<Integer>loopQueue=new LoopQueue<>();
        double time2=testQueue(loopQueue,opCount);
        System.out.println("LoopQueue,time: "+time2+" s");


    }

}
