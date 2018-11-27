package com.leetcode.algorithm;

import java.util.*;

public class TopNFamilyNames {

    public int[] intersect(int[] nums1, int[] nums2) {


        int maxLength = Math.max(nums1.length,nums2.length);


        int [] match = new int[maxLength];
        boolean [] flag = new boolean[maxLength];


        int m = 0;


        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j] && !flag[j]){
                    match[m++] = nums1[i];
                    flag[j] = true;
                }
            }
        }

        int [] result = new int[m];

        for (int i = 0; i < m; i++) {

            result[i] = match[i];

        }

        return  result;

    }

    public static void main(String[] args) {

    }
}
