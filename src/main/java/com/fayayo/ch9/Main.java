package com.fayayo.ch9;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author dalizu on 2019/1/1.
 * @version v1.0
 * @desc
 */
public class Main {


    public static void main(String[] args) {

        int a=42;

        System.out.println(((Integer)a).hashCode());//42

        int b=-42;

        System.out.println(((Integer)a).hashCode());//-42

        double c=3.1415926;
        System.out.println(((Double)c).hashCode());


        String d="immoc";
        System.out.println(d.hashCode());


        Student student=new Student(3,2,"bobo","liu");
        System.out.println(student.hashCode());


        HashSet<Student>set=new HashSet<>();
        set.add(student);

        HashMap<Student,Integer>scors=new HashMap();
        scors.put(student,100);

        //java 默认是根据对象地址来实现hashCode

        Student student2=new Student(3,2,"bobo","liu");
        System.out.println(student.hashCode());


        HashSet<Student>setAll=new HashSet<>();
        set.add(student);
        set.add(student2);
        System.out.println("SIZE:"+set.size());

    }


}
