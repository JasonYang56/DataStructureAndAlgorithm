package com.atguigu.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                Runtime.getRuntime().availableProcessors(),  //获取运行时硬件cpu个数   cpu密集型应用建议的最大线程数
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for(int i=1;i<=8;i++){
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"-->ok");
            });
        }
    }
}
