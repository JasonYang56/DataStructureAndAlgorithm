package com.atguigu.singletan;

import com.sun.imageio.plugins.common.LZWCompressor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LazyMode {
    private volatile static LazyMode lazyMode;

    private LazyMode() {
        System.out.println(Thread.currentThread().getName() + "=====");
    }

    public static LazyMode getInstance() {
        if (lazyMode == null) {
            synchronized (LazyMode.class) {
                if (lazyMode == null) {
                    lazyMode = new LazyMode();
                }
            }
        }
        return lazyMode;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        for (int i = 0; i < 20; i++) {
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + "----" + LazyMode.getInstance());
//            }, String.valueOf(i)).start();
//        }
        LazyMode instance = LazyMode.getInstance();
        Constructor<LazyMode> declaredConstructor = LazyMode.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        LazyMode instance2 = declaredConstructor.newInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
}
