package com.cf.myutil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: acmdreamer
 * @Description:
 * @Date: Create in 2017/12/9 18:47
 */
public class MyUtil {
    /**
     * @param: [n：生成个数 , upperLimit：上限整数]
     * @return java.util.List<java.lang.Integer> : 无序整数数组（整数范围：0 ~ upperLimit - 1）
     * @description:
     * @Date: 2017/12/9 19:13
     */
    public static List<Integer> getRandomIntegerArryayList(int n , int upperLimit){
        return getRandomIntegerArryayList(n,0,upperLimit);
    }

    /**
     * @param: [n：生成个数 , lowerLimit：下限整数 , upperLimit：上限整数]
     * @return java.util.List<java.lang.Integer> : 无序整数数组（整数范围：lowerLimit ~ upperLimit - 1）
     * @description:
     * @Date: 2017/12/9 19:13
     */
    public static List<Integer> getRandomIntegerArryayList(int n , int lowerLimit , int upperLimit){
        if(n <= 0) return new ArrayList<Integer>();
        long t = System.currentTimeMillis();
        Random rd = new Random(t);
        List<Integer> list = new ArrayList<Integer>(n);
        while(n-- > 0){
            list.add(rd.nextInt(upperLimit - lowerLimit) + lowerLimit);
        }
        return list;
    }
}
