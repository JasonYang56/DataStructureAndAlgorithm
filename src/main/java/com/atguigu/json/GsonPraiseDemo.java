package com.atguigu.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.List;

public class GsonPraiseDemo {
    public static void main(String[] args) {
        String JsonStr = "{\"code\":0,\"message\":\"获取积分等级列表成功\",\"data\":{\"list\":[{\"id\":2,\"integralStart\":51,\"integralEnd\":100,\"borrowAmount\":30000.00,\"createTime\":\"2020-12-08 17:02:42\",\"updateTime\":\"2022-11-05 11:14:24\",\"deleted\":false},{\"id\":3,\"integralStart\":101,\"integralEnd\":2000,\"borrowAmount\":100000.00,\"createTime\":\"2020-12-08 17:02:57\",\"updateTime\":\"2022-11-05 11:14:49\",\"deleted\":false},{\"id\":4,\"integralStart\":4000,\"integralEnd\":5000,\"borrowAmount\":300000.00,\"createTime\":\"2022-10-31 12:16:39\",\"updateTime\":\"2022-10-31 20:23:29\",\"deleted\":false},{\"id\":5,\"integralStart\":5,\"integralEnd\":6,\"borrowAmount\":2.00,\"createTime\":\"2022-11-05 11:58:23\",\"updateTime\":\"2022-11-05 11:58:23\",\"deleted\":false},{\"id\":6,\"integralStart\":5,\"integralEnd\":10,\"borrowAmount\":2.00,\"createTime\":\"2022-11-05 11:59:38\",\"updateTime\":\"2022-11-05 11:59:38\",\"deleted\":false},{\"id\":7,\"integralStart\":5,\"integralEnd\":11,\"borrowAmount\":6.00,\"createTime\":\"2022-11-05 12:02:20\",\"updateTime\":\"2022-11-05 12:02:20\",\"deleted\":false},{\"id\":8,\"integralStart\":5,\"integralEnd\":11,\"borrowAmount\":60.00,\"createTime\":\"2022-11-05 12:02:20\",\"updateTime\":\"2022-11-05 12:02:20\",\"deleted\":false},{\"id\":9,\"integralStart\":5,\"integralEnd\":11,\"borrowAmount\":6000.00,\"createTime\":\"2022-11-05 12:02:20\",\"updateTime\":\"2022-11-05 12:02:20\",\"deleted\":false}]}}";
        String jsonStr2 = "{\"id\":2,\"integralStart\":51,\"integralEnd\":100,\"borrowAmount\":30000.00,\"createTime\":\"2020-12-08 17:02:42\",\"updateTime\":\"2022-11-05 11:14:24\",\"deleted\":false}";

        String jsonStr3 = "[{\"id\":2,\"integralStart\":51,\"integralEnd\":100,\"borrowAmount\":30000.00,\"createTime\":\"2020-12-08 17:02:42\",\"updateTime\":\"2022-11-05 11:14:24\",\"deleted\":false},{\"id\":3,\"integralStart\":101,\"integralEnd\":2000,\"borrowAmount\":100000.00,\"createTime\":\"2020-12-08 17:02:57\",\"updateTime\":\"2022-11-05 11:14:49\",\"deleted\":false},{\"id\":4,\"integralStart\":4000,\"integralEnd\":5000,\"borrowAmount\":300000.00,\"createTime\":\"2022-10-31 12:16:39\",\"updateTime\":\"2022-10-31 20:23:29\",\"deleted\":false},{\"id\":5,\"integralStart\":5,\"integralEnd\":6,\"borrowAmount\":2.00,\"createTime\":\"2022-11-05 11:58:23\",\"updateTime\":\"2022-11-05 11:58:23\",\"deleted\":false},{\"id\":6,\"integralStart\":5,\"integralEnd\":10,\"borrowAmount\":2.00,\"createTime\":\"2022-11-05 11:59:38\",\"updateTime\":\"2022-11-05 11:59:38\",\"deleted\":false},{\"id\":7,\"integralStart\":5,\"integralEnd\":11,\"borrowAmount\":6.00,\"createTime\":\"2022-11-05 12:02:20\",\"updateTime\":\"2022-11-05 12:02:20\",\"deleted\":false},{\"id\":8,\"integralStart\":5,\"integralEnd\":11,\"borrowAmount\":60.00,\"createTime\":\"2022-11-05 12:02:20\",\"updateTime\":\"2022-11-05 12:02:20\",\"deleted\":false},{\"id\":9,\"integralStart\":5,\"integralEnd\":11,\"borrowAmount\":6000.00,\"createTime\":\"2022-11-05 12:02:20\",\"updateTime\":\"2022-11-05 12:02:20\",\"deleted\":false}]";

        Gson gson = new Gson();
//        IntegralGrade integralGrade = gson.fromJson(jsonStr2, IntegralGrade.class);
//        System.out.println("------"+integralGrade);
        List<IntegralGrade> list = gson.fromJson(jsonStr3, new TypeToken<List<IntegralGrade>>() {
        }.getType());

        for(IntegralGrade i:list){
            System.out.println("----------"+i);
        }


        //        Gson gson = new Gson();
//        IntegralGrade integralGrade = gson.fromJson(JsonStr, IntegralGrade.class);
//
//        System.out.println();
//        try {
//            JSONObject jsonObject = new JSONObject(JsonStr);
//            JSONObject jsonObjectData = (JSONObject) jsonObject.get("data");
//            JSONArray jsonArray = (JSONArray) jsonObjectData.get("list");
//            for(int i=0;i<jsonArray.length();i++){
//                JSONObject jo = jsonArray.getJSONObject(i);
//                Gson gson = new Gson();
//                String s = gson.toJson(jo);
//                IntegralGrade integralGrade = gson.fromJson(s, IntegralGrade.class);
//                System.out.println("---"+i+"---"+integralGrade);
//            }
//        } catch (JSONException e) {
//            throw new RuntimeException(e);
//        }

    }
}
