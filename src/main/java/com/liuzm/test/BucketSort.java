package com.liuzm.test;

import java.util.*;

public class BucketSort {
   public static void main(String[] arg){
       int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
       buckSort(array);
       String  s = Arrays.toString(array);
       System.out.println(s);

   }

    private static void buckSort(int[] array) {
        if (null == array || array.length < 2) {
            return;
        }
        int length = array.length;

        LinkedList<Integer>[] bucket = (LinkedList<Integer>[]) new LinkedList[length];

        // 待排序数组中的最大值
        int maxValue = Arrays.stream(array).max().getAsInt();
        // 根据每个元素的值，分配到对应范围的桶中
        for (int i = 0; i < array.length; i++) {
            int index = toBucketIndex(array[i], maxValue, length);
            // 没有桶才建立桶(延时)
            if (bucket[index] == null) {
                bucket[index] = new LinkedList<>();
            }
            // 有桶直接使用
            bucket[index].add(array[i]);
        }

        // 对每个非空的桶排序，排序后顺便存入临时的List，则list中已经有序）
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (bucket[i] != null) {
                Collections.sort(bucket[i]);
                temp.addAll(bucket[i]);
            }
        }

        for (int i = 0; i < length; i++) {
            array[i] = temp.get(i);
        }

    }

    private static int toBucketIndex(int value, int maxValue, int length) {
        return (value * length) / (maxValue + 1);
    }


}
