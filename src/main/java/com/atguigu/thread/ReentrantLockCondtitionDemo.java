package com.atguigu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCondtitionDemo {
    public static void main(String[] args) {
        ProduceAndConsume produceAndConsume = new ProduceAndConsume();
        new Thread(()->{
            for(int i=0;i<10;i++){
                produceAndConsume.increase();
            }
        },"A").start();
        new Thread(()->{
            for(int i=0;i<10;i++){
                produceAndConsume.decrease();
            }
        },"B").start();
    }
}

class ProduceAndConsume{
    private int shareNum=0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increase(){
        lock.lock();
        try {
            while(shareNum==1){
                condition.await();
            }
            shareNum++;
            System.out.println(Thread.currentThread().getName()+"==shareNum=="+shareNum);
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }

    }

    public void decrease(){
        lock.lock();
        try {
            while(shareNum==0){
                condition.await();
            }
            shareNum--;
            System.out.println(Thread.currentThread().getName()+"==shareNum=="+shareNum);
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
