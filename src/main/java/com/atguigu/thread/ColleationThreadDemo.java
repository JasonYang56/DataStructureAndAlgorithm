package com.atguigu.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ColleationThreadDemo {
    public static void main(String[] args) {
        ListThreadUnsafeDemo demo = new ListThreadUnsafeDemo();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo.increase();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo.decrease();
            }
        }, "B").start();


    }

}

class ListThreadUnsafeDemo {
    //    public static List<Integer>  list = new ArrayList<>();
    public static List<Integer> list = new CopyOnWriteArrayList<Integer>();

    ListThreadUnsafeDemo() {
        list.add(0);
    }

    void increase() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Integer integer = list.get(0);
        list.remove(0);
        list.add(integer + 1);
        System.out.println(Thread.currentThread().getName() + "====" + list.get(0));
    }

    void decrease() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Integer integer = list.get(0);
        list.remove(0);
        list.add(integer - 1);
        System.out.println(Thread.currentThread().getName() + "====" + list.get(0));

    }

}
