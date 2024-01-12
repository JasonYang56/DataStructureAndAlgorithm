package com.atguigu.singletan;

public class HungryMode {

//    private byte[] data1 = new byte[1024*1024];
//    private byte[] data2 = new byte[1024*1024];
//    private byte[] data3 = new byte[1024*1024];
//    private byte[] data4 = new byte[1024*1024];
//    private byte[] data5 = new byte[1024*1024];
    private static final HungryMode hungryMode = new HungryMode();

    private void HungryMode(){

    }

    private static HungryMode getInstance(){
        return hungryMode;
    }

    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"----"+HungryMode.getInstance());
            },String.valueOf(i)).start();
        }
    }
}
