package com.atguigu.selftest;

import com.oracle.webservices.internal.api.databinding.WSDLResolver;

public class StaticTest {

    public static void main(String[] args) {
        testDemo(stringBuilder,0);
        testDemo(stringBuilder,1);
        testDemo(stringBuilder,2);
    }

    private static StringBuilder stringBuilder= new StringBuilder("123");

    private static void testDemo(StringBuilder stringBuilder,int i){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(i);
        System.out.println("----->"+stringBuilder2);
    }
}
