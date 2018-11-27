<<<<<<< HEAD
package com.leetcode.algorithm;
=======
package com.sven.algorithm;
>>>>>>> branch 'master' of https://github.com/svenwang1986/leetcode.git

public class LowestPrice {

    public static void main(String[] args) {

        char[] str1 = "abcdf".toCharArray();
        char[] str2 = "ab12cd3".toCharArray();
        //cin>>str1;
        //cin>>str2;
        int M = str1.length;
        int N = str2.length;

        int dp[][]= new int[ 10][10] ;
        int ic = 5, dc = 3, rc = 2;

        dp[0][0] = 0;

        for (int i = 1; i < N + 1; i++)
            dp[0][i] = ic * i;

        for (int i = 1; i < M + 1; i++)
            dp[i][0] = dc * i;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int x = Math.min(dc + dp[i][j+1], dp[i+1][j] + ic);
                if (str1[i] != str2[j])
                    dp[i + 1][j + 1] = Math.min(dp[i][j] + rc, x);
                else
                    dp[i + 1][j + 1] = Math.min(dp[i][j], x);
            }
        }

        System.out.println(dp[M][N]);


    }
}
