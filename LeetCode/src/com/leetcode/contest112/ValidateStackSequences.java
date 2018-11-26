package com.leetcode.contest112;

import java.util.Stack;

public class ValidateStackSequences {

    public static void main(String[] args) {


        int [] pushed = {1,0,3,2};

        int [] popped = {0,1,2,3};

        boolean res = validateStackSequences(pushed,popped);


        System.out.println(res);


    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        //用一个栈模拟操作，
        //判断栈相等就出栈，否则入栈

        Stack<Integer> st = new Stack<Integer>();

        for (int i = 0,j=0; i < pushed.length && j < popped.length; i++) {

            st.push(pushed[i]);

            while (!st.isEmpty() && st.peek() == popped[j]){

                st.pop();

                j++;

            }

        }

        if (st.size() == 0) return true;


        return false;
    }

}
