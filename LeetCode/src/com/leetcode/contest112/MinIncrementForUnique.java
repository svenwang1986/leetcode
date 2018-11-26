package com.leetcode.contest112;

public class MinIncrementForUnique {

    public static void main(String[] args) {
        int [] arr = {3,2,1,2,1,7};

        int res = new MinIncrementForUnique().minIncrementForUnique(arr);

        System.out.println("res = "+res);
    }

    public int minIncrementForUnique(int[] A) {
        int [] arr = new int [50000];
        int moveTimes = 0;
        for(int i = 0; i< A.length;i++){
            
            if(arr[A[i]] == 0){
                arr[A[i]] =1;
            }else{

                for (int j = A[i]+1; ; j++) {
                    if (arr[j] ==0){
                        arr[j] =1;
                        moveTimes += j-A[i];
                        break;
                    }
                }

            }
            
            
            
        }
        
        return moveTimes;
    }
	
}
