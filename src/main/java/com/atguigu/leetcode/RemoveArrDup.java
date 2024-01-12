package com.atguigu.leetcode;

public class RemoveArrDup {
    public static void main(String[] args) {
//        int nums[] = new int[]{1,1,2,2,3,3,3,4,5,5,5,5,6,7,7,8,8,9};
        int nums[] = new int[]{1,1};
        int res = removeDuplicates(nums);
        System.out.println("------>"+res);
    }

        public static int removeDuplicates(int[] nums) {
            int resLength=nums.length;
            for(int i=0;i<resLength-1;i++){
                int index=0;
                int a=i;
                while(true){
                    if( a<resLength-1 && nums[a]==nums[a+1]){
                        a++;
                        index++;
                    }else{
                        break;
                    }
                }
                int k=i;
                if(index>0){

                    for(int j=k+index+1;j<resLength;k++,j++){
                        nums[k+1]=nums[j];
                    }
                    resLength=resLength-index;
                }

            }
            return resLength;
        }
}
