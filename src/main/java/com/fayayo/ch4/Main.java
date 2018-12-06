package com.fayayo.ch4;

/**
 * @author dalizu on 2018/11/4.
 * @version v1.0
 * @desc
 */
public class Main {


    public static void main(String[] args) {

        LinkedList<Integer>linkedList=new LinkedList<>();


        for (int i=0;i<5;i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2,666);

        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);
    }


}
