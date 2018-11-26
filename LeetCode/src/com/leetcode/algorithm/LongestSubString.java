package com.sven.algorithm;

import java.util.HashSet;

public class LongestSubString {


    public static void main(String[] args) {
        String s = "cbb";

        int res = new LongestSubString().lengthOfLongestSubstring(s);

        System.out.println("res="+res);
    }


    public int lengthOfLongestSubstring(String s) {

        //1.定义一个hashset
        HashSet<Character> set = new HashSet<>();
        //2.定义一个头，一个尾，还有一个比较值
        int i = 0;//头
        int j = 0;//尾
        int min = 0;//比较值
        while (i < s.length() && j < s.length()) {//当头尾都没有超出滑块所能移动的最大范围时
            if (!set.contains(s.charAt(j))) {//如果当前这个set不包含尾指针指向的字符
                set.add(s.charAt(j++));//滑块后移
                min = Math.max(min, j - i);
            } else {
                set.remove(s.charAt(i++));//滑块头指针后移
            }
        }
        return min;
    }


}
