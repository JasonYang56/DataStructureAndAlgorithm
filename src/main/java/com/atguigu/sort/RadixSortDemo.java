package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSortDemo {
    public static void main(String[] args) {
        int[] array = {53,3,542,748,14,214,23,121,21,1};

        System.out.println("排序前--》"+ Arrays.toString(array));

        radixSort(array);

        System.out.println("排序后--》"+ Arrays.toString(array));

//         创建要给80000个的随机的数组  80000000*4/1024/1024/1024
//        int[] arr = new int[80000000];
//        for (int i = 0; i < 80000000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//        }

//        System.out.println("排序前");
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是=" + date1Str);
//
//        radixSort(arr);
//
//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序前的时间是=" + date2Str);

    }

    public static void radixSort(int[] arr){
        int[][] bucket = new int[10][arr.length];
        int[] bucketcounts = new int[10];

        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }

        int temp = 0;
        int bigTry = (max+"").length();
        for(int i=0;i<bigTry;i++){
            for(int j=0;j<arr.length;j++){
               temp = (int) (arr[j]/Math.pow(10,i))%10;
                bucket[temp][bucketcounts[temp]] = arr[j];
                bucketcounts[temp]++;
            }
            int index = 0;
            for(int l=0;l<bucketcounts.length;l++){
                if(bucketcounts[l]>0){
                    for(int k=0;k<bucketcounts[l];k++){
                        arr[index++] = bucket[l][k];
                    }
                }
                bucketcounts[l]=0;
            }

        }
    }

}
