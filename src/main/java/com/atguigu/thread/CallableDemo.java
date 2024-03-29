package com.atguigu.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask,"A").start();
        System.out.println("====>"+futureTask.get());
    }

}

class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("call() 方法被调用了");
        return "finish!!";
    }
}
