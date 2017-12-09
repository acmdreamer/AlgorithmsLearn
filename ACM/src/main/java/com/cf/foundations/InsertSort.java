package com.cf.foundations;

import com.cf.myutil.MyUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: acmdreamer
 * @Description: 插入排序
 * @Date: Create in 2017/12/9 18:45
 */
public class InsertSort {
    static public void halfSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int low = 0, mid = 0, high = i;
            int temp = a[i];
            while (low <= high) {
                mid = (low + high) / 2;
                if (a[mid] < temp) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            // 找到要插入的位置，然后将这个位置以后的所有元素向后移动
            for (int j = i - 1; j > high; j--)

            {
                a[j + 1] = a[j];
            }
            a[high + 1] = temp;

        }
    }
    public static  void inderSort(List<Integer> list){
        int len = list.size();
        for(int sortIndex = 1; sortIndex < len;++sortIndex){
            int left = 0 , middle = 0 , right = sortIndex - 1;
            int key = list.get(sortIndex);
            if(key < list.get(sortIndex - 1)) {
                while (left <= right) {
                    middle = (left + right) >> 1;
                    int cmpNum = list.get(middle);
                    if (key < cmpNum) {
                        right = middle - 1;
                    } else{
                        left = middle + 1;
                    }
                }
                for(int i = sortIndex - 1;i>right && i>0;--i){
                    list.set(i+1,list.get(i));
                }
                list.set(right+1,key);
            }
        }
    }

    public static void main(String[] args){
        List<Integer> list = MyUtil.getRandomIntegerArryayList(100,100);
        inderSort(list);
        int len = list.size();
        for(int i=0;i<len;++i){
            System.out.print(list.get(i));
            if(i != len)System.out.print(",");
        }
    }
}
