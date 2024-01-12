package com.atguigu.algorithm.divideconquer;

public class HannoTowerDemo {
    public static void main(String[] args) {
        int n=3;
        hannoTower(n,"A","B","C");

    }

    public static void hannoTower(int num,String a,String b,String c){
        if(num==1){
            System.out.println("put "+a+" to "+ c);
        }else{
            hannoTower(num-1,a,c,b);
            System.out.println("put "+a+" to "+ c);
            hannoTower(num-1,b,a,c);
        }
    }
}
