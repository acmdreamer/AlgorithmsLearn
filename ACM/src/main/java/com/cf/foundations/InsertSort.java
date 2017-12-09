package com.cf.foundations;

import com.cf.myutil.MyUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: acmdreamer
 * @Description: 插入排序之折半查找法
 * @Date: Create in 2017/12/9 18:45
 */
public class InsertSort {
    public static  void insertSort(List<Integer> list){
        int len = list.size();
        for(int sortIndex = 1; sortIndex < len;++sortIndex){
            int left = 0 , middle = 0 , right = sortIndex - 1;
            int key = list.get(sortIndex);
            if(key < list.get(sortIndex - 1)) {
                //折半查找，指针最终必定定位于第一个大于key的数的前一个
                while (left <= right) {
                    middle = (left + right) >> 1;
                    int cmpNum = list.get(middle);
                    if (key < cmpNum) {
                        right = middle - 1;
                    } else{
                        left = middle + 1;
                    }
                }
                //数组后移
                for(int i = sortIndex - 1;i>right;--i){
                    list.set(i+1,list.get(i));
                }
                //插入
                list.set(right+1,key);
            }
        }
    }

    public static void main(String[] args){
        List<Integer> list = MyUtil.getRandomIntegerArryayList(100,100);
        insertSort(list);
        int len = list.size();
        for(int i=0;i<len;++i){
            System.out.print(list.get(i));
            if(i != len)System.out.print(",");
        }
    }
}
