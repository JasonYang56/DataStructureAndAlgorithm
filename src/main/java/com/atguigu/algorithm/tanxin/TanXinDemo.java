package com.atguigu.algorithm.tanxin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TanXinDemo {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> broadcast1  = new HashSet<>();
        broadcast1.add("北京");
        broadcast1.add("上海");
        broadcast1.add("天津");

        HashSet<String> broadcast2  = new HashSet<>();
        broadcast2.add("广州");
        broadcast2.add("北京");
        broadcast2.add("深圳");


        HashSet<String> broadcast3  = new HashSet<>();
        broadcast3.add("成都");
        broadcast3.add("上海");
        broadcast3.add("杭州");


        HashSet<String> broadcast4  = new HashSet<>();
        broadcast4.add("上海");
        broadcast4.add("天津");

        HashSet<String> broadcast5  = new HashSet<>();
        broadcast5.add("杭州");
        broadcast5.add("大连");

        broadcasts.put("k1",broadcast1);
        broadcasts.put("k2",broadcast2);
        broadcasts.put("k3",broadcast3);
        broadcasts.put("k4",broadcast4);
        broadcasts.put("k5",broadcast5);

        HashSet<String> allAreas = new HashSet<>();
        for(Map.Entry<String, HashSet<String>> area:broadcasts.entrySet()){
            allAreas.addAll(area.getValue());
        }
        //System.out.println(allAreas.toArray());
        HashSet<String> tempSet = new HashSet<>();
        HashSet<String> selectBr= new HashSet<>();
        String  maxKey = null;
        while(allAreas.size()>0){
            maxKey=null;
            for(Map.Entry<String, HashSet<String>> br:broadcasts.entrySet()){
                tempSet.clear();
                tempSet.addAll(br.getValue());
                tempSet.retainAll(allAreas);
                if(tempSet.size()>0&&(maxKey==null || tempSet.size()>broadcasts.get(maxKey).size())){
                    maxKey = br.getKey();
                }
            }
            if(maxKey!=null){
                selectBr.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }

        }

        System.out.println("------->"+ selectBr);

    }
}
