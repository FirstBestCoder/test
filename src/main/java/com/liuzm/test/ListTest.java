package com.liuzm.test;

import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
//        int[] temp = new int[10];
//        System.out.println(temp[1]);
        ArrayList<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(1);
        }
        System.out.println(list.get(8));

       list.add(2,10);
        Integer integer = list.get(2);
        System.out.println(integer);
    }
}
