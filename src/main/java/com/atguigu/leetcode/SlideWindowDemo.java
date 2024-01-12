package com.atguigu.leetcode;

import java.util.*;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 */
public class SlideWindowDemo {

    public static void main(String[] args) {
//        String s1="ab";
//        String s2="eidboaoo";
//        String s1="adc";
//        String s2="dcda";
//        String s1="hello";
//        String s2="ooolleoooleh";
//        System.out.println("----->"+checkInclusion(s1,s2));
//        HashMap<String,String> map1 = new HashMap<String,String>();
//        HashMap<String,String> map2 = new HashMap<String,String>();
//        map1.put("1","a");
//        map1.put("2","b");
//
//        map2.put("1","a");
//        map2.put("2","b");

//        System.out.println(map1.equals(map2));
//        List<Character> set1 = new ArrayList<>();
//        List<Character> set2 = new ArrayList<>();
//
//        set1.add('h');
//        set1.add('e');
//        set1.add('l');
//        set1.add('l');
//        set1.add('o');
//
//        set2.add('h');
//        set2.add('e');
//        set2.add('l');
//        set2.add('o');
//        set2.add('o');
////
//        System.out.println(set2.containsAll(set1));

        String s = "abba";
        System.out.println("maxSubStr's len is "+maxSubStr(s));

    }



    public static  boolean checkInclusion(String s1, String s2) {
        List<Character> set1 = new ArrayList<>();
        List<Character> set2 = new ArrayList<>();


        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        for(int i=0;i<ch1.length;i++){
            set1.add(ch1[i]);
        }
        int j;
        for(j=0;j<ch2.length;j++){
            if(j < ch1.length){
                set2.add(ch2[j]);
            }else{
                if(set2.containsAll(set1)){
                    if(isMatch(set1,set2)){
                        return true;
                    }
                }else{
                    char c = ch2[j-ch1.length];
                    set2.remove(new Character(c));
                    set2.add(ch2[j]);
                }
            }
        }
        if(set2.containsAll(set1)){
            if(isMatch(set1,set2)){
                return true;
            }
        }
        return false;

    }

    public static boolean isMatch(List<Character> set1,List<Character> set2){
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(Character c:set1){
            if(map1.get(c)==null){
                map1.put(c,1);
            }else{
                map1.put(c,map1.get(c)+1);
            }
        }
        for(Character c:set2){
            if(map2.get(c)==null){
                map2.put(c,1);
            }else{
                map2.put(c,map2.get(c)+1);
            }
        }
        if(map1.equals(map2)){
            return true;
        }
        return false;
    }

    public static int maxSubStr(String s){
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = map.get(s.charAt(i)) + 1;
//                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
