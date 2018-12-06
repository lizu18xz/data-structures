package com.fayayo.ch1;

/**
 * @author dalizu on 2018/10/20.
 * @version v1.0
 * @desc
 */
public class Student {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s,score: %d)",name,score);
    }

    public static void main(String[] args) {

        Array<Student>array=new Array<>();

        array.addLast(new Student("alice",100));
        array.addLast(new Student("lz",88));
        array.addLast(new Student("xio",99));

        System.out.println(array);

    }

}
