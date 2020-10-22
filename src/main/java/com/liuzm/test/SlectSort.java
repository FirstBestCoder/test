package com.liuzm.test;

import java.util.Arrays;

public class SlectSort {
    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        selcetSort(array);
        String s = Arrays.toString(array);
        System.out.println(s);
    }

    private static void selcetSort(int[] array) {
        if(null == array || array.length < 2 ){
            return;
        }
        int length = array.length;
        for (int i = 0; i < length ; i++) {
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[index]){
                    index = j;
                }
            }
            if (index != i){
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }

    }
}
