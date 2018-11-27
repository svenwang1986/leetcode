package com.leetcode.algorithm;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"clower","flow","flight"};

        String res = longestCommonPrefix(strs);

        System.out.println(res);
    }


    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        if (strs.length == 1) return strs[0];

        String commonPrefix = strs[0];

        for(int i=1;i<strs.length;i++){

            int j = 0;

            while ( j < commonPrefix.length() && j < strs[i].length()) {

                if (commonPrefix.charAt(j) != strs[i].charAt(j)){

                    if (j ==0){

                        return "";

                    }

                    break;

                }

                j++;
            }

            commonPrefix = commonPrefix.substring(0,j);
        }

        return commonPrefix;
    }
}
