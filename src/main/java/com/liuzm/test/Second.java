package com.liuzm.test;

import java.util.Arrays;

public class Second {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        radixSort(array);
        String s = Arrays.toString(array);
        System.out.println(s);
    }

    private static void radixSort(int[] array) {
        if (null == array || array.length < 2) {
            return;
        }
        int length = array.length;
        int maxValue = array[0];
        for (int arr : array) {
            if (maxValue < arr) {
                maxValue = arr;
            }
        }
        int digit = (maxValue + "").length();
        int[] count = new int[11];
        int[] result = new int[length];
        for (int d = 0; d < digit; d++) {
            for (int i = 0; i < length; i++) {
                int index = digitPopular(array[i], d);
                count[index+1]++;
            }
            for (int i = 0; i < count.length-1; i++) {
                count[i+1] += count[i];
            }
            for (int i = 0; i < length ; i++) {
                int index = digitPopular(array[i], d);
                int sortIndex = count[index]++;
                result[sortIndex] = array[i];
            }
            for      (int i = 0; i < length; i++) {
                array[i] = result[i];
            }
            for (int i = 0; i < 10; i++) {
                count[i] = 0;
            }

        }

    }

    private static int digitPopular(int value, int d) {

        return (int) (value / Math.pow(10, d)) % 10;
    }


}
