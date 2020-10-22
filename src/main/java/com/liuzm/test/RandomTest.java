package com.liuzm.test;


import java.util.Arrays;

public class RandomTest {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        Sort(array);
        String s = Arrays.toString(array);
        System.out.println(s);
    }

    private static void Sort(int[] array) {
        if (null == array || array.length < 2) {
            return;
        }
        int length = array.length;
        int minValue = array[0];
        int maxValue = array[0];
        for (int arr : array) {
            if (maxValue < arr) {
                maxValue = arr;
            }
            if (minValue > arr) {
                minValue = arr;
            }
        }
        int offset = maxValue - minValue + 1;
        int[] count = new int[offset + 1];
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            count[array[i] -minValue +1]++;
        }
        for (int i = 0; i < offset; i++) {
            count[i+1] += count[i];
        }
        for (int i = 0; i < length; i++) {
            int index = array[i] -minValue ;
            result[count[index]++] = array[i];
        }
        for (int i = 0; i < length; i++) {
            array[i] = result[i];
        }
    }
}
