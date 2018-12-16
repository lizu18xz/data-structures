package com.fayayo.ch7;

import java.util.ArrayList;

/**
 * @author dalizu on 2018/12/16.
 * @version v1.0
 * @desc 基于二分搜索树的集合
 */
public class BSTSet<E extends Comparable<E>>implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        this.bst = new BST<E>();
    }

    @Override
    public void add(E e) {

        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


    }
}
