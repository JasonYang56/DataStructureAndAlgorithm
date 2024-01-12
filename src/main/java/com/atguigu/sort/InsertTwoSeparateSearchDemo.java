package com.atguigu.sort;

import java.util.ArrayList;

//插值查找法（在二分法的基础上找到自适应的mid）
public class InsertTwoSeparateSearchDemo {
    public static void main(String[] args) {
//        int[] array = {-12,-3,0,2,67,78,130,150};
        int[] array = {-12,-3,0,2,67,67,67,78,78,78,78,130,150};

        ArrayList arrayList = new ArrayList();
//        System.out.println("The index is "+twoSeparateSearch2(array,0,array.length-1,150,arrayList).toString());

        System.out.println("The index is "+twoSeparateSearch(array,0,array.length-1,67));

    }

    //重复数据只能找到一个
    private static int twoSeparateSearch(int[] arr,int left,int right,int queryVal){
        System.out.println("111");
        if(left>right){
            return -1;
        }
//        int mid = (left+right)/2;
        int mid = left + (right-left)*(queryVal-arr[left])/(arr[right]-arr[left]);
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
        System.out.println("222");

        if(left>right || queryVal<arr[0] || queryVal>arr[arr.length-1]){
            return arrayList;
        }
//        int mid = (left+right)/2;

        int mid = left + (right-left)*(queryVal-arr[left])/(arr[right]-arr[left]);
        if(mid > arr.length){
            return arrayList;
        }
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
