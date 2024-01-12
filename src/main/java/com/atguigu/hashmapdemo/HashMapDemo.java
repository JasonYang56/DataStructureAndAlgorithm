package com.atguigu.hashmapdemo;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
//    String[] strings = new String[]{"abc","bcd","acef","xyz","az","ba","a","z"};
//    groupStrings(strings);

//    int i=4,j=7;
//    String key = new String(i/3+""+j/3);
//        System.out.println("key====>"+key);


        int[] nums = new int[]{2,5,7,3,9};
        int target = 10;

        System.out.println(testSumTwo(nums,target));

    }

    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = lowIt(s);
//            System.out.println(s+"====>"+key.toString());
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private static String lowIt(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if (n <= 0) return "";
        char f = s.charAt(0);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) - f < 0) {
                sb.append((char) (26 - f + s.charAt(i)));
                System.out.println(s+"===>"+(char) (26 - f + s.charAt(i)));
            } else {
                sb.append((char) (s.charAt(i) - f));
            }
        }
        return sb.toString();
    }

    public static int[] testSumTwo(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        int index=0;
        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];
            if(!map.containsKey(temp)){
                map.put(nums[i],i);
            }else{
                result[0] = map.get(temp);
                result[1] = i;
            }
        }

        return result;
    }


}
