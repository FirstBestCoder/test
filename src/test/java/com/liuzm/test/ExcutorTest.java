package com.liuzm.test;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExcutorTest {

    @Test
    public void test1() {
        final ThreadPoolExecutor executor = new ThreadPoolExecutor(
                //核心线程数
                2,
                //最大线程数
                2,
                //空闲线程的存活时间
                1L,
                TimeUnit.SECONDS,
                //阻塞队列，先进先出
                new ArrayBlockingQueue<>(4),
                //拒绝策略，不抛弃任何任务
                new ThreadPoolExecutor.CallerRunsPolicy());
        PrinterTask printerTask = new PrinterTask();
        for (int i = 0; i < 10; i++) {
            executor.execute(printerTask);
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
