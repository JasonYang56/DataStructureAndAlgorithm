package com.atguigu.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo2 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for(int i=1;i<11;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"占用车位");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println(Thread.currentThread().getName()+"释放车位");
                    semaphore.release();
                }
            },i+"").start();
        }
    }
}
