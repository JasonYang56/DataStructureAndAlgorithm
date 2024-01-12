package com.atguigu.thread;

import java.util.concurrent.locks.ReentrantLock;

public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        },"A").start();

        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        },"B").start();

        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        },"C").start();
    }
}
