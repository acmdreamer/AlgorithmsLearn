package com.cf.foundations;

import com.cf.myutil.MyUtil;

import java.util.List;

/**
 * @Author: acmdreamer
 * @Description: 最大子数组
 * @Date: Create in 2017/12/10 22:06
 */
public class LargestSubArray {
    //线性扫描法，记录最大的值。一旦和小于0，放弃之前扫描过的数，重新计和
    public static int largestSubArray(List<Integer> list){
        int ptr = 0 , sum = 0 , maxSum = Integer.MIN_VALUE;
        while(ptr < list.size()){
            sum += list.get(ptr);
            if(sum < 0)sum = 0;
            else if(sum > maxSum)maxSum = sum;
            ptr++;
        }
        return maxSum;
    }

    //- - - - - - - - - - - - - - -

    //递归分治法 依据算法导论书P40
    private static int findMaxCrossingSubArray(List<Integer> list , int low , int mid , int high){
        int left_sum = Integer.MIN_VALUE;
        int sum = 0;
        //从中心点向左半部遍历算最大连续和
        for(int i = mid ; i >= low ; i--){
            sum += list.get(i);
            if(sum > left_sum)left_sum = sum;
        }
        int right_sum = Integer.MIN_VALUE;
        sum = 0;
        //从中心点向右半部遍历算最大连续和
        for(int j = mid + 1 ; j <= high ; j++){
            sum += list.get(j);
            if(sum > right_sum)right_sum = sum;
        }
        return left_sum + right_sum;
    }

    public static int findMaximumSumArray(List<Integer> list , int low , int high){
        if(high == low)return list.get(high);
        int mid = (low + high) >>> 1;
        //找出左半部最大子数组
        int left_sum = findMaximumSumArray(list , low , mid);
        //找出右半部最大子数组
        int right_sum = findMaximumSumArray(list , mid + 1, high);
        //找出穿过中心点的最大子数组
        int cross_sum = findMaxCrossingSubArray(list , low , mid , high);
        //取各个数组的最大值即为结果
        int result = Math.max(Math.max(left_sum , right_sum) , cross_sum);
        return result;
    }

    //- - - - - - - - - - - - - - -

    //测试
    public static void main(String[] args){
        List<Integer> list = MyUtil.getRandomIntegerArryayList(10,-100 , 100);
        //int result = largestSubArray(list);
        int result = findMaximumSumArray(list , 0 , list.size() - 1);
        int len = list.size();
        for(int i=0;i<len;++i){
            System.out.print(list.get(i));
            if(i != len)System.out.print(",");
        }
        System.out.println("\n最大子数组和为: " + result);
    }
}
