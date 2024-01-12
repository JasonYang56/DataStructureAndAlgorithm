package com.atguigu.heaposort;

import java.util.Arrays;

public class HeapSortDemo {

    public static void main(String[] args) {
        int arr[] = {4,6,8,5,9,12,43,0,-232,-1,1};
        headSort(arr,"big");
        headSort(arr,"small");

    }

    public static void headSort(int arr[],String type){
        System.out.println("heap sort");
        for(int i=arr.length/2-1;i>=0;i--){
            if("big".equals(type)){
                adjustBIgHeap(arr,i,arr.length);
            }else if("small".equals(type)){
                adjustSmallHeap(arr,i,arr.length);
            }
        }

        int temp = 0;
        for(int j = arr.length-1;j>0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            if("big".equals(type)){
                adjustBIgHeap(arr,0,j);

            }else if("small".equals(type)){
                adjustSmallHeap(arr,0,j);

            }
        }

        System.out.println("------>"+ Arrays.toString(arr));
    }

    public static void adjustBIgHeap(int arr[],int i,int length){
        int temp = arr[i];
        for(int k=2*i+1;k<length;k=2*k+1){
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k]>temp){
                arr[i] = arr[k];
                i=k;
            }else{
                break;
            }
        }

        arr[i] = temp;

    }

    public static void adjustSmallHeap(int arr[],int i,int length){
        int temp = arr[i];
        for(int k=2*i+1;k<length;k=2*k+1){
            if(k+1<length && arr[k]>arr[k+1]){
                k++;
            }
            if(arr[k]<temp){
                arr[i] = arr[k];
                i=k;
            }else{
                break;
            }
        }

        arr[i] = temp;

    }
}
