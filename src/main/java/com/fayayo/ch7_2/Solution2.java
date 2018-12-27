package com.fayayo.ch7_2;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author dalizu on 2018/12/19.
 * @version v1.0
 * @desc 给定两个数组，编写一个函数来计算它们的交集。
 * nums1 = [1,2,2,1], nums2 = [2,2]
   输出: [2,2]
 */
public class Solution2 {

    public int[] intersection(int[] nums1, int[] nums2) {

        //元素，频次
        TreeMap<Integer,Integer>treeMap=new TreeMap<>();

        for (int num:nums1){
            if(!treeMap.containsKey(num)){
                treeMap.put(num,1);
            }else {
                treeMap.put(num,treeMap.get(num)+1);
            }
        }

        ArrayList<Integer>list=new ArrayList<>();

        for (int num:nums2){
            if(treeMap.containsKey(num)){
                list.add(num);
                treeMap.put(num,treeMap.get(num)-1);
                if(treeMap.get(num)==0){
                    treeMap.remove(num);
                }
            }
        }


        int []res=new int[list.size()];

        for (int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }

        return res;

    }


}
