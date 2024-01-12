package com.atguigu.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CasDemo {
    public static void main(String[] args) {
//        AtomicInteger atomicInteger = new AtomicInteger(1);
//        System.out.println(atomicInteger.compareAndSet(1, 2));
//        System.out.println("atomicInteger===="+atomicInteger.get());
//        System.out.println(atomicInteger.compareAndSet(2, 3));
//        System.out.println("atomicInteger===="+atomicInteger.get());

        AtomicStampedReference<String> stringAtomicStampedReference = new AtomicStampedReference<>("S",1);

        new Thread(()->{
            int stamp = stringAtomicStampedReference.getStamp();

            System.out.println(Thread.currentThread().getName()+"==stamp==>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"====>"+stringAtomicStampedReference.compareAndSet("S", "O",
                    stringAtomicStampedReference.getStamp(), stringAtomicStampedReference.getStamp() + 1));
            System.out.println(Thread.currentThread().getName()+"==stamp==>"+stringAtomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"====>"+stringAtomicStampedReference.compareAndSet("O", "S",
                    stringAtomicStampedReference.getStamp(), stringAtomicStampedReference.getStamp() + 1));
        },"A").start();;
        new Thread(()->{
            int stamp = stringAtomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"==stamp==>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"====>"+stringAtomicStampedReference.compareAndSet("S", "X",
                    stamp, stamp + 1));
            System.out.println(Thread.currentThread().getName()+"==stamp==>"+stringAtomicStampedReference.getStamp());
        },"B").start();;
    }
}
