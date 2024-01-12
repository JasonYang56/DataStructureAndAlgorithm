package com.atguigu.singletan;


public class LazyLoadModeTest {
    private volatile static LazyLoadModeTest LazyLoadModeTest;
    private LazyLoadModeTest(){

    }

    public LazyLoadModeTest getInstance(){

            if(LazyLoadModeTest== null){
                synchronized (LazyLoadModeTest.class){
                    if(LazyLoadModeTest== null){
                        return new LazyLoadModeTest();
                    }
                }
            }


        return LazyLoadModeTest;
    }

}
