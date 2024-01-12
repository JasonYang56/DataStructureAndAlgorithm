package com.atguigu;

import org.junit.Test;

public class ShiShuArr {
    @Test
    public void test4ShiShu(){
        int[][] oriArr = new int[11][11];
        oriArr[1][2] = 1;
        oriArr[2][3] = 2;
        //遍历输出原始数据
//        for(int i=0;i<11;i++){
//            for(int j=0;j<11;j++){
//                System.out.printf("%d\t",oriArr[i][j]);
//            }
//            System.out.println();
//        }
        //遍历输出原始数据   换种方式
//        for(int[] row:oriArr){
//            for(int data:row){
//                System.out.printf("%d\t",data);
//            }
//            System.out.println();
//        }

        //使用稀疏数据存储原始数据
        int[][] ssArr = new int[3][3];
        ssArr[0][0]=11;
        ssArr[0][1]=11;
        ssArr[0][2]=2;

        int count=0;
        for(int i =0;i<11;i++){
            for(int j=0;j<11;j++){
                if(oriArr[i][j]!=0){
                    count++;
                    ssArr[count][0] = i;
                    ssArr[count][1] = j;
                    ssArr[count][2] = oriArr[i][j];
                }
            }
        }

        for(int[] row:ssArr){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        //将稀疏数组的数据还原为原始数据
        int oriArr2[][] = new int[ssArr[0][0]][ssArr[0][1]];
        for(int i=1;i<3;i++){
            oriArr2[ssArr[i][0]][ssArr[i][1]] = ssArr[i][2];
        }

        //遍历输出原始数据   换种方式
        for(int[] row:oriArr2){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        System.out.println("hot-fix 111112");
        System.out.println("hot-fix 555555");
    }
}
