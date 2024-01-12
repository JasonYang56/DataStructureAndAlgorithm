package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * {9|5,10,40,0,-1,-100,20};
 * {5,9|10,40,0,-1,-100,20};
 * {5,9,10|40,0,-1,-100,20};
 * {5,9,10,40|6,-1,-100,20};     i=4   tempIndex=3
 * {5,9,10,40|40,-1,-100,20};  6    2
 * {5,9,10,40|40,-1,-100,20};  6
 * {5,9,10,10|40,-1,-100,20};  6     1
 * {5,9,9,10|40,-1,-100,20};  6
 * {5,5,9,10|40,-1,-100,20};  0
 * {0,5,9,10,40|,-1,-100,20};  0
 */
public class InsertSortDemo {

    public static void main(String[] args) {
//        int[] array = {9, 5, 10, 40, 0, -1, -100, 20};
        int[] array = new int[8];
//        System.out.println("原始的数组为" + Arrays.toString(array));
        InsertSortDemo insertSortDemo = new InsertSortDemo();
//        int[] finalArr = insertSortDemo.insertSort(array);
        insertSortDemo.generateArray(array);
                System.out.println("原始的数组为" + Arrays.toString(array));

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        System.out.println("--->"+sdf.format(date));
        insertSortDemo.insertSort2(array);
        Date date2 = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        System.out.println("--->"+sdf2.format(date2));
//        insertSort3(array);
//        System.out.println("排序后数组为"+ Arrays.toString(finalArr));
        System.out.println("排序后数组为" + Arrays.toString(array));

    }

    private void generateArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*80000);
        }
    }

    //需要新创造一个数组，空间冗余度高  自己写的
    private int[] insertSort(int[] array) {
        int[] tempArray = new int[array.length];
        int tempNo;
        boolean flag = false;
        for (int i = 0; i < tempArray.length; i++) {
            if (i == 0) {
                tempNo = array[i];
                tempArray[i] = tempNo;
            } else {
                for (int j = 0; j < i; j++) {
                    if (array[i] < tempArray[j]) {
                        flag = true;
                        for (int k = 0; k < i - j; k++) {
                            tempNo = tempArray[i - k - 1];
                            tempArray[i - k] = tempNo;
                        }
                        tempNo = array[i];
                        tempArray[j] = tempNo;
                        break;
                    }
                }
                if (!flag) {
                    tempArray[i] = array[i];
                } else {
                    flag = false;
                }
            }
            tempNo = 0;
        }
        return tempArray;
    }

    //使用原始数组进行位置交换，空间冗余度低  自己写的
    private void insertSort2(int[] array) {
        int tempIndex = 0;

        for (int i = 1; i < array.length; i++) {
            tempIndex = i - 1;
            int current = array[i];
            while (tempIndex >= 0 && current > array[tempIndex]) {
                array[tempIndex + 1] = array[tempIndex];
                tempIndex--;
            }
            array[tempIndex + 1] = current;

        }


    }

    //插入排序
    public static void insertSort3(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //使用for循环来把代码简化
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[1]的前面这个数的下标

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            //这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            //System.out.println("第"+i+"轮插入");
            //System.out.println(Arrays.toString(arr));
        }
    }
}
