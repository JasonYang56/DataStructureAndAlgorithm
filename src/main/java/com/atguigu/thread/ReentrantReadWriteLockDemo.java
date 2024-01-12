package com.atguigu.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
//        MyReadWriteLockCache myReadWriteLock = new MyReadWriteLockCache();
//        for(int i=1;i<6;i++){
//            int temp = i;
//            new Thread(()->{
//                myReadWriteLock.put(temp,temp*100);
//            },String.valueOf(i)).start();
//        }
//        for(int i=1;i<6;i++){
//            int temp = i;
//            new Thread(()->{
//                myReadWriteLock.get(temp);
//            },String.valueOf(i)).start();
//        }

        MyVolatileCache myVolatileCache = new MyVolatileCache();
        for (int i = 1; i < 6; i++) {
            int temp = i;
            new Thread(() -> {
                myVolatileCache.put(temp, temp * 100);
            }, String.valueOf(i)).start();
        }
        for (int i = 1; i < 6; i++) {
            int temp = i;
            new Thread(() -> {
                myVolatileCache.get(temp);
            }, String.valueOf(i)).start();
        }


    }
}

class MyReadWriteLockCache {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public Integer get(Integer key) {
        Integer integer = null;
        try {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "正在读取");

            integer = map.get(key);
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "读取完成==>" + integer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
        return integer;
    }

    public void put(Integer key, Integer value) {
        try {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "正在写入==>" + key + "--" + value);
//            TimeUnit.SECONDS.sleep(2);
            map.put(key, value);
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "写入完成");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }

    }

}

class MyVolatileCache {
    private volatile Map<Integer, Integer> map = new HashMap<>();

    public Integer get(Integer key) {
        Integer integer = null;
        try {
            System.out.println(Thread.currentThread().getName() + "正在读取");
            TimeUnit.SECONDS.sleep(2);
            integer = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成==>" + integer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
        return integer;
    }

    public void put(Integer key, Integer value) {
        try {
            System.out.println(Thread.currentThread().getName() + "正在写入==>" + key + "--" + value);
            TimeUnit.SECONDS.sleep(2);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完成");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
        }

    }
}
