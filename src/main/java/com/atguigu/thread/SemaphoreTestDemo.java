package com.atguigu.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTestDemo {
    public static void main(String[] args) {
        // 表示有2个许可.
        Semaphore sem = new Semaphore(1);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    // 默认使用一个许可.
                    sem.acquire();
                    System.out.println(Thread.currentThread().getName() + " I get it.");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + " I release it.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    sem.release();
                }
            },"第"+(i+1)+"线程").start();
        }
    }

    @Test
    public void testCPU(){
        System.out.println("==>"+Runtime.getRuntime().availableProcessors());

    }
}
