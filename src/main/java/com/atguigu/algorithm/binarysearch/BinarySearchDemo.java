package com.atguigu.algorithm.binarysearch;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int arr[] = {-10,-5,-1,3,5,7,23,56,78,123,500};
        int result = binarySearch1(arr,0,arr.length-1,600);
        System.out.println("using the method 1 ,the result is "+ result);

        int result2 = binarySearch2(arr,0,arr.length-1,600);
        System.out.println("using the method 2 ,the result2 is "+ result2);

    }

    /**
     * 递归二分法查找
     * @param arr
     * @param n
     * @return
     */
    public static int binarySearch1(int arr[],int left,int right,int n){
        System.out.println(1);
        if(left>right){
            return -1;
        }
        int mid = (left+right)/2;
        if(arr[mid]==n){
            return mid;
        }else if(arr[mid]>n){
            return binarySearch1(arr,left,mid-1,n);
        }else {
            return binarySearch1(arr,mid+1,right,n);
        }
    }

    /**
     * 非递归二分法查找
     * @param arr
     * @param left
     * @param right
     * @param n
     * @return
     */
    public static int binarySearch2(int arr[],int left,int right,int n){
        int mid;

        while(true){
            System.out.println(2);

            if(left>right){
                return -1;
            }
            mid = (left+right)/2;
            if(arr[mid]==n){
                return mid;
            }else if(arr[mid]>n){
                right=mid-1;
            }else{
                left = mid+1;
            }
        }
    }
}
