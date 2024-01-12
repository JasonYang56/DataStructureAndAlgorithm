package com.atguigu.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CompleteFutureDemo {
    public static void main(String[] args) {
        NetMall jd = new NetMall("jd","mysql");
        NetMall pdd = new NetMall("pdd","mysql");
        NetMall taobao = new NetMall("taobao","mysql");
        List<NetMall> netMalls = Arrays.asList(jd, pdd, taobao);

        long start = System.currentTimeMillis();
        extracted(netMalls);
        long end = System.currentTimeMillis();
        System.out.println("花费时间=====》"+(end-start));


        System.out.println("-----------------------");


        long start2 = System.currentTimeMillis();
        extracted2(netMalls);
        long end2 = System.currentTimeMillis();
        System.out.println("花费时间=====》"+(end2-start2));




    }

    private static void extracted(List<NetMall> netMalls) {
        netMalls.stream().map(netMall -> {
            double price = 0;
            try {
                price = netMall.getPrice(netMall.getMallName(), netMall.getProName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return String.format(netMall.getProName()+"in %s price is %.2f",netMall.getMallName(),price);
        }).collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void extracted2(List<NetMall> netMalls) {
        netMalls.stream().map(netMall ->
            CompletableFuture.supplyAsync(()->{
                double price = 0;
                try {
                    price = netMall.getPrice(netMall.getMallName(), netMall.getProName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return String.format(netMall.getProName()+"in %s price is %.2f",netMall.getMallName(),price);
            })).collect(Collectors.toList()).stream().map(s->s.join()).collect(Collectors.toList()).forEach(System.out::println);

    }

}

@Data
@AllArgsConstructor
@Accessors(chain = true)
class NetMall{
    public String mallName;
    public String proName;
//    public double price;

    public double getPrice(String mallName,String proName) throws InterruptedException {
        Thread.sleep(1000);
        return ThreadLocalRandom.current().nextDouble()+ mallName.charAt(0)+proName.charAt(0);
    }
}
