package com.leetcode.contest112;

public class MinIncrementForUnique {

	
	public int minIncrementForUnique(int[] A) {
        int [] arr = new int [40001];
        int moveTimes = 0;
        for(int i = 0; i< A.length;i++){
            
            if(arr[A[i]] == 0){
                arr[A[i]] =1;
            }else{
                moveTimes ++ ;
                A[i] ++;
                i--;
            }
            
            
            
        }
        
        return moveTimes;
    }
	
}
