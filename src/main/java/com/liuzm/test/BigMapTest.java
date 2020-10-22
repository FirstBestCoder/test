package com.liuzm.test;

import java.util.BitSet;

public class BigMapTest {
    public static void main(String[] args) {
        BitSet bigSet = new  BitSet(10);
        int[] arr = new int[]{1,2,3,5,7};
        for (int i = 0; i < 5; i++) {
            bigSet.set(arr[i]);
        }
        if (bigSet.get(11)){
            System.out.println("======有这个数字=======");
        }else{
            System.out.println("不存在这个数字");
        }

        if(bigSet.equals(1)){
            System.out.println("发现数字5");
        }else{
            System.out.println("没有数字5");
        }
    }
}
