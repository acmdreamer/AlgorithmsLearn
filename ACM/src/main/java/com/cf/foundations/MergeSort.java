package com.cf.foundations;

import com.cf.myutil.MyUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: acmdreamer
 * @Description: 归并排序
 * @Date: Create in 2017/12/9 23:03
 */
public class MergeSort {
    //合并过程
    public static void merge(List<Integer> list , int left , int mid , int right){
        List<Integer> temp = new ArrayList<Integer>(right - left + 1);
        int leftPtr = left , rightPtr = mid + 1;
        while(true) {
            //设置哨兵
            int leftNum = leftPtr == mid + 1 ? Integer.MAX_VALUE : list.get(leftPtr);
            int rightNum = rightPtr == right + 1 ? Integer.MAX_VALUE : list.get(rightPtr);
            //两个都是哨兵则停止循环
            if(leftNum == Integer.MAX_VALUE && rightNum == Integer.MAX_VALUE)break;
            //取小的数填充
            if(leftNum <= rightNum){
                temp.add(leftNum);
                leftPtr++;
            }else {
                temp.add(rightNum);
                rightPtr++;
            }
        }
        //将中转有序数组更新到原数组对应区域
        for(int index = left , i = 0 ; index <= right ; ++index , ++i){
            list.set(index , temp.get(i));
        }
    }

    //归并排序
    public static void mergeSort(List<Integer> list , int left , int right){
        if(left < right) {
            int mid = (left + right) >>> 1;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list , left , mid , right);
        }
    }

    public static void main(String[] args){
        List<Integer> list = MyUtil.getRandomIntegerArryayList(100,100);
        mergeSort(list,0,list.size() - 1);
        int len = list.size();
        for(int i=0;i<len;++i){
            System.out.print(list.get(i));
            if(i != len)System.out.print(",");
        }
    }
}
