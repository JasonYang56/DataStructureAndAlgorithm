package com.atguigu.recursive;

public class EightQueue {
    private int maxNum = 8;

    private static int modeNum=0;

    private static int tryNum = 0;
    private int[] arrQueue = new int[maxNum];

    public static void main(String[] args) {
        EightQueue eightQueue = new EightQueue();
        eightQueue.play(0);
        System.out.println("一共有"+modeNum+"种方式");
        System.out.println("一共尝试了"+tryNum+"次");
    }

    private void play(int n){
        if(n==maxNum){
            printChess();
//            return;
        }else{
            for(int i=0;i<maxNum;i++){
                arrQueue[n] = i;
                if(check(n)){
                    play(n+1);
                }
            }

        }
    }

    //检查下第 n+1个棋子是否与前面其他棋子冲突
    private boolean check(int n){
        tryNum++;
        for(int i=0;i<n;i++){
            if(arrQueue[i]==arrQueue[n] || Math.abs(n-i)==Math.abs(arrQueue[n]-arrQueue[i])){
                return false;
            }
        }
        return true;
    }


    private void printChess(){
        modeNum++;
        for (int i:arrQueue){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
