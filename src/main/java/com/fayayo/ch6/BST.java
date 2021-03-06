package com.fayayo.ch6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author dalizu on 2018/12/6.
 * @version v1.0
 * @desc 二分搜索树  Comparable  具有可比较性
 */
public class BST<E extends Comparable<E>> {


    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }


    private Node root;//根节点
    private int size;//元素个数

    public BST() {
        root = null;
        size = 0;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //添加元素
    public void add(E e) {
        root = add(root, e);
    }

    //向以node为根的二分搜索树中添加元素E,递归算法
    private Node add(Node node, E e) {

        //终止条件
        if (node == null) {
            size++;
            return new Node(e);
        }

        //递归操作
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;

    }


    public boolean contains(E e) {

        return contains(root, e);

    }

    //以node为根的二分搜索树是否包含元素e
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }


    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //前序遍历以node为根的二分搜索树
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //前序遍历 非递归
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();//栈顶取出元素
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }


    //中序遍历(结果是顺序的)
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);

    }

    //后序遍历(结果是顺序的)
    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(Node node) {
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(node.e);
    }


    //二分搜索树 层序遍历  广度优先
    public void levelOrder() {

        Queue<Node> queue = new LinkedList<>();//队列先进先出
        queue.add(root);
        while (!queue.isEmpty()) {

            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }

        }
    }


    //寻找最小元素
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return minimum(root).e;
    }

    //返回以node为根的二分搜索树最小值
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }


    //寻找最大元素
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return maximum(root).e;
    }

    //返回以node为根的二分搜索树最大值
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return minimum(node.right);
    }

    //删除最小值
    public E romoveMin() {
        E ret = minimum();

        root = romoveMin(root);

        return ret;
    }

    //删除以node为根的二分搜索树最小节点
    private Node romoveMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = romoveMin(node.left);
        return node;
    }


    //删除最大值
    public E romoveMax() {
        E ret = maximum();

        root = romoveMax(root);

        return ret;
    }

    //删除以node为根的二分搜索树最大节点
    private Node romoveMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = romoveMax(node.right);
        return node;
    }

    //从二分搜索树中删除元素e
    public void remove(E e) {

        root = remove(root, e);

    }

    private Node remove(Node node, E e) {

        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {//e==node.e

            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = romoveMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }

    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append(" _ _");
        }
        return res.toString();
    }



    /*   //添加元素
    public void add(E e){
        if(root == null){
            root = new Node(e);
            size++;
        }else {
            add(root,e);
        }
    }

    //向以node为根的二分搜索树中添加元素E,递归算法
    private void add(Node node,E e){

        //终止条件
        if(e.equals(node.e)){
            return;
        }else if(e.compareTo(node.e)<0 && node.left==null){//小于
            node.left=new Node(e);
            size++;
            return;
        }else if(e.compareTo(node.e)>0 && node.right==null){
            node.right=new Node(e);
            size++;
            return;
        }

        //递归操作
        if(e.compareTo(node.e)<0){
            add(node.left,e);
        }else {
            add(node.right,e);
        }
    }*/


}
