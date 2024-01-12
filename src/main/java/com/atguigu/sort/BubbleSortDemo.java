package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

//冒泡排序
public class BubbleSortDemo {


    public static void main(String[] args) {
//        int[] arr = {-2,0,-5,30,20,5};
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] array = new int[80000];


//        SelectSortDemo        selectSortDemo = new SelectSortDemo();

        generateArray(array);

//        System.out.println("原始的数组为："+ Arrays.toString(array));

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        System.out.println(sdf.format(date));


        bubbleSort(array);

        Date date2 = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        System.out.println(sdf.format(date2));
    }
    private static void generateArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = new Random().nextInt()*80000;
        }
    }

    private static void bubbleSort(int[] oriArr){
        int temp=0;
        boolean flag = false;
        for(int i=0;i<oriArr.length-1;i++){
            for(int j=0;j<oriArr.length-1-i;j++){
                if(oriArr[j]>oriArr[j+1]){
                    flag = true;
                    temp = oriArr[j];
                    oriArr[j] = oriArr[j+1];
                    oriArr[j+1] = temp;
                }
            }
            if(!flag){
                break;
            }else{
                flag=false;
            }
        }
    }
}
