package com.leetcode.algorithm;

import java.util.HashSet;

public class LongestSubString {


    public static void main(String[] args) {
        String s = "cbb";

        int res = new LongestSubString().lengthOfLongestSubstring(s);

        System.out.println("res="+res);
    }


    public int lengthOfLongestSubstring(String s) {

        //1.瀹氫箟涓�涓猦ashset
        HashSet<Character> set = new HashSet<>();
        //2.瀹氫箟涓�涓ご锛屼竴涓熬锛岃繕鏈変竴涓瘮杈冨��
        int i = 0;//澶�
        int j = 0;//灏�
        int min = 0;//姣旇緝鍊�
        while (i < s.length() && j < s.length()) {//褰撳ご灏鹃兘娌℃湁瓒呭嚭婊戝潡鎵�鑳界Щ鍔ㄧ殑鏈�澶ц寖鍥存椂
            if (!set.contains(s.charAt(j))) {//濡傛灉褰撳墠杩欎釜set涓嶅寘鍚熬鎸囬拡鎸囧悜鐨勫瓧绗�
                set.add(s.charAt(j++));//婊戝潡鍚庣Щ
                min = Math.max(min, j - i);
            } else {
                set.remove(s.charAt(i++));//婊戝潡澶存寚閽堝悗绉�
            }
        }
        return min;
    }


}
