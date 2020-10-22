package com.liuzm.test;

public class BreakTest {
    public static void main(String[] args) {

        boolean flag = true;
        while (flag) {
            for (int i = 0; i < 5; i++) {
                if (i == 2) {
                    flag = false;
                    System.out.println("=====123======");
            }

            }
        }

        System.out.println("=====结束====");
    }
}
