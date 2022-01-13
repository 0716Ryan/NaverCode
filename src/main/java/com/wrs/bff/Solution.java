package com.wrs.bff;

import sun.security.util.Length;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param arrA int整型一维数组 
     * @param K int整型 
     * @return int整型一维数组
     */
    public int[] tranArr (int[] arrA, int K) {
        // write code here

        int[] arrB = new int[arrA.length];
        int[] result = new int[2];
        int min = 9999;
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i]<min){
                min = arrA[i];
            }
        }
//        int num = 0;
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] - min == K){
//                num = arrA[i];
                result[0] = min+K;
                result[1] = arrA[i];
            } else if (arrA[i] - min == K*2){
                result[0] = min+K;
                result[1] = arrA[i]-K;
            }
        }

        return  result;
    }
    public static int count;

    public int getMaxValue (int[] nums, int[] values) {
        // write code here
        int recursive = recursive(nums, values, 0, 0, nums.length - 1, 0);
        return recursive;

    }

    public static int recursive(int[] nums, int[] values,int index,int first,int last, int sum){

        if(index == values.length || count >100){
            return sum;
        }
        count ++;
        int max =Math.max(recursive(nums,values,index+1,first+1,last,sum+nums[first]*values[index]),recursive(nums,values,index+1,first,last-1,sum+nums[last]*values[index]));

        return max;
    }

//    public int getMaxValue (int[] nums, int[] values) {
//        // write code here
//        int dp[] = new int[nums.length+1];
//        int leftIndex = 0;
//        int rightIndex = nums.length-1;
//        int i = 1;
//        for (int value : values) {
//            if (leftIndex > rightIndex){
//                return dp[nums.length];
//            }
//
//            if (nums[leftIndex] > nums[rightIndex]){
//                dp[i] = dp[i-1] + nums[leftIndex] * value;
//                leftIndex++;
//            } else {
//                dp[i] = dp[i-1] + nums[rightIndex] * value;
//                rightIndex--;
//            }
//            i++;
//
//        }
//        return dp[nums.length];
//
//    }

    public static void main(String[] args) {
//        int[] arrA = {1,6,9,8};
//        int k = 3;
//        int[] ints = new Solution().tranArr(arrA, k);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
//        System.out.println(ints);
        int[] a = {1,3,5,2,4};
        int[] b = {1,2,3,4,5};
        System.out.println(new Solution().getMaxValue(a, b));
    }
}