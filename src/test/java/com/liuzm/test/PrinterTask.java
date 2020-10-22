package com.liuzm.test;

import java.util.concurrent.atomic.AtomicInteger;

public class PrinterTask implements Runnable {


    private static final AtomicInteger num = new AtomicInteger(0);

    public PrinterTask() {

    }

    @Override
    public void run() {
        for (int i = 0; i <= 50; i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "打印的数字为 ： " + num.getAndIncrement());
        }
    }
}
