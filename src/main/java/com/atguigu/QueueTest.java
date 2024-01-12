package com.atguigu;

import java.lang.reflect.Array;
import java.util.Scanner;

public class QueueTest {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);


        System.out.println(1%10 + " "+1/10);

        Scanner scn = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("请输入指令：");
            System.out.println("a（add）添加队列：");
            System.out.println("s（show）显示队列：");
            System.out.println("h（head）显示头部：");
            System.out.println("t（tail）显示尾部：");
            System.out.println("o（out） 取出队列：");
            System.out.println("e（exit）退出：");

            String commond = scn.nextLine();
            switch (commond){
                case "a":
                    System.out.println("请输入一个数字：");
                    int input = scn.nextInt();
                    try {
                        arrayQueue.addItem(input);
                    }catch(Exception e){
                    System.out.println(e.getMessage());
                    }
                    break;
                case "o":
                    try {
                       int outNum = arrayQueue.outItem();
                        System.out.println("取出的数字为："+outNum);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "s":
                    try{
                        arrayQueue.showQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "h":
                    try{
                        arrayQueue.showHead();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "t":
                    try{
                        arrayQueue.showTail();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scn.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }

    }
}
class ArrayQueue{
    private int front;
    private int tail;
    private int maxSize;
    private int[] arrQueue;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.tail = 0 ;
        this.arrQueue = new int[maxSize];
    }

    public boolean isFull(){
        if(tail == maxSize){
            return true;
        }else{
            return false;
        }
    }

    public boolean isQueueEmpty(){
        if(front == tail){
            return true;
        }else{
            return false;
        }
    }

    public void addItem(int i){
        if(!isFull()){
            this.arrQueue[this.tail] = i;
            this.tail++;
        }else{
            throw new RuntimeException("队列已满，无法添加");
        }
    }

    public int outItem(){
        if(!isQueueEmpty()){
            int outNum = arrQueue[front];
            this.front++;
            return outNum;
        }else{
            throw new RuntimeException("队列为空，不能取数");
        }

    }

    public void showQueue(){
//        for (int data:this.arrQueue) {
//            System.out.printf("--%d--",data);
//            System.out.println();
//        }
        for(int i=front;i<maxSize;i++){
            System.out.printf("--%d--",arrQueue[i]);
            System.out.println();
        }
    }

    public void showHead(){
        if(isQueueEmpty()){
            throw new RuntimeException("队列为空，无法显示队首");
        }else{
            System.out.println("the head is:"+arrQueue[front]);
        }
    }

    public void showTail(){
        if(isQueueEmpty()){
            throw new RuntimeException("队列为空，无法显示队尾");
        }else{
            System.out.println("the tail is:"+arrQueue[tail-1]);
        }
    }
}
