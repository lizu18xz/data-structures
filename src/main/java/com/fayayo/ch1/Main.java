package com.fayayo.ch1;

/**
 * @author dalizu on 2018/10/20.
 * @version v1.0
 * @desc
 */
public class Main {

    public static void main(String[] args) {

        Array<Integer> array=new Array<Integer>(10);
        for (int i=0;i<10;i++)
            array.addLast(i);


        System.out.println(array);

        array.add(1,100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        System.out.println(array.get(2));


        array.remove(2);
        System.out.println(array);

        System.out.println(array.contains(100));

        array.removeElement(4);
        System.out.println(array);

        int size=3;
        size--;
        System.out.println(size);



    }

}
