package com.atguigu.stack;

import java.util.Scanner;

public class StackOfArrDemo {
    public static void main(String[] args) {
        StackOfArr stack = new StackOfArr(10);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (true){
            System.out.println("请输入操作指令数字：");
            System.out.println("1——>入栈");
            System.out.println("2——>出栈");
            System.out.println("3——>显示栈");
            System.out.println("4——>退出栈");
            int opt = scanner.nextInt();

            switch (opt){
                case 1:
                    System.out.println("请输入一个数字：");
                    int input = scanner.nextInt();
                    stack.push(input);
                    break;
                case  2:
                    stack.pop();
                    break;
                case 3:
                    stack.show();
                    break;
                case 4:
                    loop = false;
                    scanner.close();
                    break;
                default:
                    break;
            }


        }
    }
}

class StackOfArr{
    private int top = -1;
    private int[] stackArr;
    private int maxSize;

    public StackOfArr(int maxSize) {
        this.maxSize = maxSize;
        this.stackArr = new int[maxSize];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top == (maxSize-1);
    }

    public void push(int i){
        if(!isFull()){
            top++;
            stackArr[top]=i;
        }else{
            System.out.println("此栈已满");
        }
    }

    public int pop(){
        if(!isEmpty()){
            int retValue = stackArr[top];
            top--;
            return retValue;
        }else{
            System.out.println("此栈为空");
            return -1;
        }
    }

    public void show(){
        if(!isEmpty()){
            for(int i=top;i>=0;i--){
                System.out.println("----->"+stackArr[i]);
            }
        }else{
            System.out.println("此栈为空");

        }

    }
}
