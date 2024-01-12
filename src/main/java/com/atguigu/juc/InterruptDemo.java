package com.atguigu.juc;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class InterruptDemo {
//    private static volatile boolean signal = false;

    private static AtomicBoolean signal = new AtomicBoolean(false);
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "---接到停止信号，中断操作");
                    System.out.println("isInterrupted()===="+Thread.currentThread().isInterrupted());
                    break;
                }
//                System.out.println("isInterrupted()===="+Thread.currentThread().isInterrupted());
                System.out.println(Thread.currentThread().getName() + "---执行操作");
            }
        }, "t1");
        t1.start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"---发送中断信号");
                t1.interrupt();
//                signal.set(true);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"线程2").start();

    }
}
