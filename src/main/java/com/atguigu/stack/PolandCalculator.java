package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandCalculator {

    public static void main(String[] args) {

        //(3+4)*5-6=29
//        String suffixStr = "3 4 + 5 * 6 -";
//        int result = 0;

//        List<String> list = paraseStr2List(suffixStr);
//
//        result = calculate(list);
//
//        System.out.println(suffixStr+" = "+result);
//        String midExpStr = "(329+480)*504-690";
        String midExpStr = "(32+48)*50-690";
        List<String> midList = midExp2List(midExpStr);
        List<String> suffixExpList = midExpConvertSuffixExp(midList);
        System.out.println("转换为List的中缀表达式 -->"+midList);
        System.out.println("转换为List的逆波兰表达式-->"+suffixExpList);

        System.out.println("计算转换为List的逆波兰表达式--->"+midExpStr+" = "+calculate(suffixExpList));

    }

    public static boolean isOperation(String str){
        return (str.equals("+") || str.equals("-") || str.equals("*") ||str.equals("/"));
    }

    //将带有空格分割的字符串转为列表
    public static List<String> paraseStr2List(String str){
        if(null!=str && !"".equals(str)){
            String[] strArr = str.split(" ");
            List<String> list = new ArrayList<String>();
            for(String item:strArr){
                list.add(item);
            }
            return list;
        }else{
            throw new RuntimeException("字符串输入有误");
        }
    }

    //将后缀表达式（逆波兰表达式）的List计算得出结果
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<String>();
        int ret = 0;
        try{
            for(String item:list){
                if(item.matches("\\d+")){
                    stack.push(item);
                }else if(isOperation(item)){
                    int num1  = Integer.parseInt(stack.pop());
                    int num2  = Integer.parseInt(stack.pop());
                    ret = 0;
                    if("+".equals(item)){
                        ret = num2+num1;
                    }else if("-".equals(item)){
                        ret = num2-num1;
                    }else if("*".equals(item)){
                        ret = num2 * num1;
                    }else if("/".equals(item)){
                        ret = num2 / num1;
                    }
                    stack.push(String.valueOf(ret));
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Integer.parseInt(stack.pop());
    }

//    将中缀表达式的List转化为后缀表达式（逆波兰表达式）的List
    public static List<String> midExpConvertSuffixExp(List<String> list){
        Stack<String> optStack = new Stack<String>();
        List<String> resultList = new ArrayList<String>();

        for(String item:list){
            if(item.matches("\\d+")){
                resultList.add(item);
            }else if(isOperation(item)){
                if(optStack.size()==0||optStack.peek().equals("(")){
                    optStack.push(item);
                }else if(optPriority(item)<=optPriority(optStack.peek())){
                    resultList.add(optStack.pop());
                    while(true){
                        if(optStack.size()==0||optStack.peek().equals("(")){
                            optStack.push(item);
                            break;
                        }else if(optPriority(item)<=optPriority(optStack.peek())) {
                            resultList.add(optStack.pop());
                        }else if(optPriority(item)>optPriority(optStack.peek())){
                            optStack.push(item);
                            break;
                        }
                    }

                }else if(optPriority(item)>optPriority(optStack.peek())){
                    optStack.push(item);
                }else{
                    throw new RuntimeException("运算符处理出错");
                }
            }else if("(".equals(item)){
                optStack.push(item);
            }else if(")".equals(item)){
                while (true){
                    String top = optStack.pop();
                    if(top.equals("(")){
                        break;
                    }
                    resultList.add(top);
                }
            }
        }

        for(int i=0;i<optStack.size();i++){
            resultList.add(optStack.pop());
        }
        return resultList;
    }

    public static int optPriority(String opt){
        if("*".equals(opt) || "/".equals(opt)){
            return 2;
        }else if("+".equals(opt) || "-".equals(opt)){
            return  1;
        }
        return 0;
    }

    public static List<String> midExp2List(String str){
        List<String> list = new ArrayList<String>();
        String helpStr = "";
        char tempChar;
        int tempIndex;
        for(int i=0;i<str.length()-1;i++){
            tempChar = str.substring(i,i+1).charAt(0);
            if( tempChar >= 48 && tempChar<= 57){
                helpStr="";
                helpStr = helpStr+tempChar;
                while(true){
                    tempIndex = i+1;
                    if(tempIndex<str.length()){
                        tempChar = str.substring(tempIndex,tempIndex+1).charAt(0);
                        if(tempChar >= 48 && tempChar<= 57){
                            helpStr = helpStr+tempChar;
                            i++;
                        }else{
                            break;
                        }
                    }else{
                        break;
                    }
                }
                list.add(helpStr);
            }else{
                list.add(""+tempChar);
            }
        }
        return list;
    }
}

