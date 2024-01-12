package com.atguigu.httpinteract;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetAndPostRequestDemo {

    public static void main(String[] args) {
        String url = "http://localhost:8110/admin/core/integralGrade/list";

        String JsonStr = "{\"code\":0,\"message\":\"获取积分等级列表成功\",\"data\":{\"list\":[{\"id\":2,\"integralStart\":51,\"integralEnd\":100,\"borrowAmount\":30000.00,\"createTime\":\"2020-12-08 17:02:42\",\"updateTime\":\"2022-11-05 11:14:24\",\"deleted\":false},{\"id\":3,\"integralStart\":101,\"integralEnd\":2000,\"borrowAmount\":100000.00,\"createTime\":\"2020-12-08 17:02:57\",\"updateTime\":\"2022-11-05 11:14:49\",\"deleted\":false},{\"id\":4,\"integralStart\":4000,\"integralEnd\":5000,\"borrowAmount\":300000.00,\"createTime\":\"2022-10-31 12:16:39\",\"updateTime\":\"2022-10-31 20:23:29\",\"deleted\":false},{\"id\":5,\"integralStart\":5,\"integralEnd\":6,\"borrowAmount\":2.00,\"createTime\":\"2022-11-05 11:58:23\",\"updateTime\":\"2022-11-05 11:58:23\",\"deleted\":false},{\"id\":6,\"integralStart\":5,\"integralEnd\":10,\"borrowAmount\":2.00,\"createTime\":\"2022-11-05 11:59:38\",\"updateTime\":\"2022-11-05 11:59:38\",\"deleted\":false},{\"id\":7,\"integralStart\":5,\"integralEnd\":11,\"borrowAmount\":6.00,\"createTime\":\"2022-11-05 12:02:20\",\"updateTime\":\"2022-11-05 12:02:20\",\"deleted\":false},{\"id\":8,\"integralStart\":5,\"integralEnd\":11,\"borrowAmount\":60.00,\"createTime\":\"2022-11-05 12:02:20\",\"updateTime\":\"2022-11-05 12:02:20\",\"deleted\":false},{\"id\":9,\"integralStart\":5,\"integralEnd\":11,\"borrowAmount\":6000.00,\"createTime\":\"2022-11-05 12:02:20\",\"updateTime\":\"2022-11-05 12:02:20\",\"deleted\":false}]}}";

        getRequest(url,null);

//        GsonFormat
    }

    public static Object getRequest(String url, Map<String,String> paramMap){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder builder;
        try{
            List<NameValuePair> pairs;
            if(paramMap !=null){
                pairs = new ArrayList<>();
                for(Map.Entry<String,String> entry:paramMap.entrySet()){
                    pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                builder = new URIBuilder(url).setParameters(pairs);
            }else{
                builder = new URIBuilder(url);
            }
            CloseableHttpResponse response;
            HttpGet httpGet = new HttpGet(builder.build());
            response = httpClient.execute(httpGet);
            if(response!=null && response.getStatusLine().getStatusCode() == 200){
                HttpEntity httpEntity = response.getEntity();
                String jsonStr = EntityUtils.toString(httpEntity);
//                JSONArray jsonArray = new JSONArray();


                JSONObject jsonObject = new JSONObject(jsonStr);
                System.out.println("message-------->"+jsonObject.get("message"));

                JSONObject jsonObjectData = (JSONObject)jsonObject.get("data");
                JSONArray jsonArray = (JSONArray)jsonObjectData.get("list");


//                JSONArray jsonArray = jsonObject.getJSONArray("data");

//                JSONArray jsonArray = jsonObject.getJSONArray("list");
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jo = jsonArray.getJSONObject(i);
                    System.out.println("borrowAmount------->"+jo.get("borrowAmount"));

//                    IntegralGrade integralGrade = jo.;
                }
                JSONArray jsonArray2 = jsonObject.getJSONArray("list");
//                System.out.println("message-------->"+jsonObject.get("message"));
                return jsonObject;

            }



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}


