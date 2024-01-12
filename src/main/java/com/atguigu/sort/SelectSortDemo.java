package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

//选择排序
public class SelectSortDemo {


    public static void main(String[] args) {
//        int[] array = {20,-1,3,2,0,10};

        int[] array = new int[80000];


        SelectSortDemo selectSortDemo = new SelectSortDemo();

        selectSortDemo.generateArray(array);

//        System.out.println("原始的数组为："+ Arrays.toString(array));

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        System.out.println(sdf.format(date));


        selectSortDemo.selectSort(array);

        Date date2 = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        System.out.println(sdf.format(date2));

//        System.out.println("排序后数组为："+ Arrays.toString(array));

    }


    private void generateArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = new Random().nextInt()*80000;
        }
    }

    private void selectSort(int[] array){
        int tempIndex = 0;
        int temp = 0;
        int counts = 0;
        boolean flag = false;
        for(int i=0;i<array.length-1;i++){
            tempIndex=i;
            for(int j=i;j<array.length-1;j++){
                if(array[tempIndex]>array[j+1]){
                    tempIndex=j+1;
                    counts++;
                }

            }
                temp = array[i];
                array[i] = array[tempIndex];
                array[tempIndex]=temp;

            temp=0;
            tempIndex=0;
//            }

        }
        System.out.println("---->"+counts);
    }

}
