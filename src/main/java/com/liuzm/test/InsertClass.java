package com.liuzm.test;

import java.util.Arrays;

public class InsertClass {
    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        insertSort(array);
        String s = Arrays.toString(array);
        System.out.println(s);
    }

    private static void insertSort(int[] array) {
        if(null == array || array.length < 2 ){
            return;
        }
        int length = array.length;
        int insertNum;
        for (int i = 1; i < length; i++) {
            insertNum = array[i];
            int j = i - 1;
            while(j >= 0 && insertNum < array[j] ){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = insertNum;
        }

    }
}
