package com.atguigu.sort;

import java.util.Arrays;

public class MergeSortDemo {

    public static void main(String[] args) {
        int[] array = {8,3,2,5,1,4,7,6};
        int[] temp = new int[array.length];

        mergeSort(array,0,array.length-1,temp);

        System.out.println("------>"+ Arrays.toString(array));
    }


    private static void mergeSort(int[] array,int left,int right,int[] temp){
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(array,left,mid,temp);
            mergeSort(array,mid+1,right,temp);

            merge(array,left,mid,right,temp);
        }
    }

    private static void merge(int[] array,int left,int mid,int right,int[] temp){
        System.out.println("VVVVVV");

        int i = left;
        int j = mid+1;
        int t=0;

        while(i<=mid && j<=right){
            if(array[i]<=array[j]){
                temp[t] = array[i];
                t++;
                i++;
            }else{
                temp[t] = array[j];
                t++;
                j++;
            }
        }

        while(i<=mid){
            temp[t] = array[i];
            t++;
            i++;
        }

        while(j<=right){
            temp[t] = array[j];
            t++;
            j++;
        }

        int tempLeft = left;
        t=0;
        while(tempLeft<=right){
            array[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }

    }
}
