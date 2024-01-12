package com.atguigu.json;


import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

public class FastJsonDemo {
    public static void main(String[] args) {
        String jsonStr = "{\"id\":2,\"integralStart\":51,\"integralEnd\":100,\"borrowAmount\":30000.00,\"createTime\":\"2020-12-08 17:02:42\",\"updateTime\":\"2022-11-05 11:14:24\",\"deleted\":false}";

        String jsonStr2 = "[{\"id\":2,\"integralStart\":51,\"integralEnd\":100,\"borrowAmount\":30000.00,\"createTime\":\"2020-12-08 17:02:42\",\"updateTime\":\"2022-11-05 11:14:24\",\"deleted\":false},{\"id\":3,\"integralStart\":101,\"integralEnd\":2000,\"borrowAmount\":100000.00,\"createTime\":\"2020-12-08 17:02:57\",\"updateTime\":\"2022-11-05 11:14:49\",\"deleted\":false},{\"id\":4,\"integralStart\":4000,\"integralEnd\":5000,\"borrowAmount\":300000.00,\"createTime\":\"2022-10-31 12:16:39\",\"updateTime\":\"2022-10-31 20:23:29\",\"deleted\":false},{\"id\":5,\"integralStart\":5,\"integralEnd\":6,\"borrowAmount\":2.00,\"createTime\":\"2022-11-05 11:58:23\",\"updateTime\":\"2022-11-05 11:58:23\",\"deleted\":false},{\"id\":6,\"integralStart\":5,\"integralEnd\":10,\"borrowAmount\":2.00,\"createTime\":\"2022-11-05 11:59:38\",\"updateTime\":\"2022-11-05 11:59:38\",\"deleted\":false},{\"id\":7,\"integralStart\":5,\"integralEnd\":11,\"borrowAmount\":6.00,\"createTime\":\"2022-11-05 12:02:20\",\"updateTime\":\"2022-11-05 12:02:20\",\"deleted\":false},{\"id\":8,\"integralStart\":5,\"integralEnd\":11,\"borrowAmount\":60.00,\"createTime\":\"2022-11-05 12:02:20\",\"updateTime\":\"2022-11-05 12:02:20\",\"deleted\":false},{\"id\":9,\"integralStart\":5,\"integralEnd\":11,\"borrowAmount\":6000.00,\"createTime\":\"2022-11-05 12:02:20\",\"updateTime\":\"2022-11-05 12:02:20\",\"deleted\":false}]";


        IntegralGrade integralGrade = JSON.parseObject(jsonStr, IntegralGrade.class);

        System.out.println("integralGrade------>"+integralGrade);

        List<IntegralGrade> list = JSON.parseArray(jsonStr2, IntegralGrade.class);

        for(IntegralGrade i:list){
            System.out.println("List------>"+i);
        }

        IntegralGrade integralGrade1 = new IntegralGrade();
        integralGrade1.setId(100);
        integralGrade1.setIntegralStart(5);
        integralGrade1.setIntegralEnd(10);
        integralGrade1.setBorrowAmount(1000);

        String s = JSON.toJSONString(integralGrade1);
        System.out.println("jsonStr------_>"+s);

        IntegralGrade integralGrade2 = new IntegralGrade();
        integralGrade2.setId(150);
        integralGrade2.setIntegralStart(10);
        integralGrade2.setIntegralEnd(100);
        integralGrade2.setBorrowAmount(5000);
        integralGrade2.setDeleted(true);
        integralGrade2.setCreateTime("11111");
        integralGrade2.setUpdateTime("22222");

        List<IntegralGrade> list2 = new ArrayList<>();
        list2.add(integralGrade);
        list2.add(integralGrade1);
        list2.add(integralGrade2);

        String s1 = JSON.toJSONString(list2);

        System.out.println("list json------>"+s1);


    }

//    JSON.

}
