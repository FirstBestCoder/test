package com.liuzm.count;


import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcLinkQue {
    public static void main(String[] args) {

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
        queue.offer("123");
        queue.offer("234");
        Object[] objects = queue.toArray();
        System.out.println(objects[0] + ", " + objects[1]);

        //将数据存储到指定数组
        String[] s = new String[2];
        queue.toArray(s);
        System.out.println(Arrays.toString(s));

    }
}
