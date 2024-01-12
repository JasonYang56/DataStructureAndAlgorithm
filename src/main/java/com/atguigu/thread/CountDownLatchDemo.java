package com.atguigu.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"====>start");
                countDownLatch.countDown();
            },i+"").start();
        }
        countDownLatch.await();
        System.out.println("main method is invoked");
    }
}
