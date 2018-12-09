package com.fayayo.ch6;

/**
 * @author dalizu on 2018/12/6.
 * @version v1.0
 * @desc
 */
public class Main {

    public static void main(String[] args) {

        BST<Integer>bst=new BST<>();

        int num[]={5,3,6,8,4,2};

        for(int n:num){
               bst.add(n);
        }
        /*bst.preOrder();

        bst.preOrderNR();
        System.out.println();
        System.out.println(bst);*/

        bst.levelOrder();
    }
}
