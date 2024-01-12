package com.atguigu.sort;

import java.util.ArrayList;

public class TwoSeparateSearchDemo {
    public static void main(String[] args) {
        int[] array = {-12,-3,0,2,67,67,67,78,78,78,78,130,150};

        ArrayList arrayList = new ArrayList();
        System.out.println("The index is "+twoSeparateSearch2(array,0,array.length-1,-12,arrayList).toString());
    }

    //重复数据只能找到一个
    private static int twoSeparateSearch(int[] arr,int left,int right,int queryVal){
        if(left>right){
            return -1;
        }
        int mid = (left+right)/2;
        if(queryVal<arr[mid]){
            return twoSeparateSearch(arr,left,mid-1,queryVal);
        }else if(queryVal>arr[mid]){
            return twoSeparateSearch(arr,mid+1,right,queryVal);
        }else{
            return mid;
        }

    }
    //可以找到全部相符的数值
    private static ArrayList twoSeparateSearch2(int[] arr, int left, int right, int queryVal,ArrayList arrayList){
//        ArrayList arrayList = new ArrayList();
        if(left>right){
            return arrayList;
        }
        int mid = (left+right)/2;
        if(queryVal<arr[mid]){
             return twoSeparateSearch2(arr,left,mid-1,queryVal,arrayList);
        }else if(queryVal>arr[mid]){
             return twoSeparateSearch2(arr,mid+1,right,queryVal,arrayList);
        }else{
            twoSeparateSearch2(arr,left,mid-1,queryVal,arrayList);
            arrayList.add(mid);
            twoSeparateSearch2(arr,mid+1,right,queryVal,arrayList);
            return arrayList;
        }

    }

}
