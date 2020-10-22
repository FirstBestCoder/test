package com.liuzm.test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class NumberTest {

    @Test
    public void testNum() {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);//true

        Integer a1 = new Integer(100);
        System.out.println(a1 == a);
    }



    @Test
    public void testString(){
        String s = new String("abc");
        String sb = s.substring(0, 1);
        System.out.println(s);
        System.out.println(sb);
    }

    @Test
    public void testHashcode(){

        int a = lengthOfLongestSubstring("aaaaa");
        System.out.println(a);
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        byte[] b = s.getBytes();
        Set set = new HashSet();
        int result = 0;
        for(int i = 0 ; i < length ; i++){
            int temp = i;
            while(temp > 0){
                if(set.contains(b[i])){
                    result = result > (i-temp) ? result : (i-temp);
                }
                temp--;
            }
            set.add(b[i]);
        }
        return result;

    }
}
