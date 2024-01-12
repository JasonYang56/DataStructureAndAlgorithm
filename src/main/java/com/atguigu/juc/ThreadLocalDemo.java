package com.atguigu.juc;

import org.junit.Test;

public class ThreadLocalDemo {
    public static final ThreadLocal<String> aa = new ThreadLocal<String>();

    @Test
    public void test1(){
        new Thread(()->{

            aa.set("111");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"----->"+aa.get());
        },"T1").start();

        new Thread(()->{
            aa.set("222");
            System.out.println(Thread.currentThread().getName()+"----->"+aa.get());
        },"T2").start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
