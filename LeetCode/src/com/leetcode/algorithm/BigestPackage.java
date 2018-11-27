package com.leetcode.algorithm;

public class BigestPackage {


    public static void main(String[] args) {

        int cap = 10;

        int v[] = {42, 12, 40, 25};
        int w[] = {7, 3, 4, 5};

        int dp[][] = new int[5][11];
        System.out.println(dp[0][0]);

        for (int i = 1; i <= v.length; i++) {

            for (int j = 1; j <= cap; j++) {
                if (j >= w[i - 1]) {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i-1]);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[v.length][cap]);

    }


}
