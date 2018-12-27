package com.fayayo.ch8;

import java.util.*;
import java.util.PriorityQueue;

/**
 * @author dalizu on 2018/12/27.
 * @version v1.0
 * @desc 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class Solution2 {

    private class Freq {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

    }


    private class FreqComparator implements Comparator<Freq>{

        @Override
        public int compare(Freq o1, Freq o2) {

            return o1.freq - o2.freq;
        }

    }


    public List<Integer> topKFrequent(int[] nums, int k) {

        //统计元素的频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<Freq>(new FreqComparator());
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().e);
        }

        return res;
    }

}
