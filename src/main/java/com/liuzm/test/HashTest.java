package com.liuzm.test;

public class HashTest {
    private volatile int a = 123;
    public static void main(String[] args) {
        String s1 = "123456";
        String s11 = "123457";
        String s12 = "125456";
        String s2 = "666666";
        String s3 = "888888";
        System.out.println(s1.hashCode()/1000);
        System.out.println(s11.hashCode()/1000);
        System.out.println(s12.hashCode()/1000);
        System.out.println(s2.hashCode()/1000);
        System.out.println(s3.hashCode()/1000);

        char i = 'a';
        char j = 'b';
        int num = 'b' - '0';
        System.out.println(num);
    }

}
