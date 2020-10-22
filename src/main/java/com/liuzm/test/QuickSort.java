package com.liuzm.test;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
       int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        quickSort(array);
        String s = Arrays.toString(array);
        System.out.println(s);
    }

    private static void quickSort(int[] array) {
        if (null == array ) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (null == array || left >= right || array.length <= 1) {
            return;
        }
        int mid = partion(array,left,right);
        quickSort(array,left,mid);
        quickSort(array,mid+1,right);

    }

    private static int partion(int[] array, int left, int right) {
        int temp = array[left];
        while(right > left){
            while(temp <= array[right] && right > left){
                right--;
            }
            if (right > left){
                array[left] = array[right];
                left++;
            }
            while(temp >= array[left] && right > left){
                left++;
            }
            if(right > left){
                array[right] = array[left];
                right--;
            }
        }
        array[left] = temp;
        return left;
    }
}
