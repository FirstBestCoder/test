package com.liuzm.test;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        shellSort(array);
        String s = Arrays.toString(array);
        System.out.println(s);
    }

    private static void shellSort(int[] array) {
        if (null == array || array.length < 2) {
            return;
        }
        int length = array.length;
        int temp,gap = length / 2;
        while (gap > 0) {

            for (int i = gap; i < length; i++) {
                int preIndex = i - gap;
                temp = array[i];
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }
}
