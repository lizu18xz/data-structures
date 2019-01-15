package com.fayayo.ch9;

/**
 * @author dalizu on 2019/1/1.
 * @version v1.0
 * @desc
 * 0~9 是 48~57
   a~z 是 97~122
   A~Z 是 65~90
 */
public class Solution {

    public int firstUniqChar(String s) {


        int [] freq=new int[26];

        for (int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'a']++;
        }

        for (int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }

}
