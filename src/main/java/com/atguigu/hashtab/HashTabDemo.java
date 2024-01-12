package com.atguigu.hashtab;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入指令信息：");
            System.out.println("add：增加员工");
            System.out.println("list：显示全部员工信息");
            System.out.println("find：查找员工信息");
            System.out.println("exit：退出程序");
            String input = scanner.next();
            switch (input){
                case "add":
                    System.out.println("请输入员工ID：");
                    int id = scanner.nextInt();
                    System.out.println("请输入员工姓名：");
                    String name = scanner.next();
                    Employee emp = new Employee(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.listAll();
                    break;
                case "find":
                    System.out.println("请输入员工ID：");
                    int tempId = scanner.nextInt();
                    Employee employee = hashTab.findById(tempId);
                    System.out.println("员工信息为："+employee.getId()+"----"+employee.getName());
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
            }
        }

    }

}

//定义一个员工类
class Employee{
    private int id;
    private String name;
    private Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getNext() {
        return next;
    }

    public void setNext(Employee next) {
        this.next = next;
    }
}

//定义一个员工链表类

class EmpLinkedList{
    Employee head;

    //直接添加到列表末端  还可根据员工id按照顺序进行添加  待实现
    public void add(Employee emp){
        if(head == null){
            head = emp;
        }else{
            Employee curEmp = head;
            while(true){
                if(curEmp.getNext()!=null){
                    curEmp = curEmp.getNext();
                }else{
                    break;
                }
            }
            curEmp.setNext(emp);
        }
    }

    public Employee findByid(int id){
        if(head == null){
            System.out.println("链表为空");
            return null;
        }else{
            Employee curEmp = head;
            boolean isFind = false;
            while(curEmp != null){
                if(curEmp.getId()== id){
                    isFind = true;
                    break;
                }else{
                    curEmp = curEmp.getNext();
                }
            }
            if(isFind){
                return curEmp;
            }else{
                System.out.println("未能找到该员工信息");
                return  null;
            }

        }
    }

    public void list(){
        if(head == null){
            System.out.println("链表为空");
        }else{
            Employee curEmp = head;
            while(curEmp!=null){
                System.out.println("员工ID："+curEmp.getId()+"员工姓名："+curEmp.getName());
                curEmp = curEmp.getNext();
            }
        }
    }
}
//定义一个哈希列表类，即一个存放员工列表类的数组
class HashTab{
    private int size;
    private EmpLinkedList[] hashTabList;

    public HashTab(int size) {
        this.size = size;
        this.hashTabList = new EmpLinkedList[size];
    }

    public void add(Employee emp){
        int id = emp.getId();
        int index = chooseLinkedList(id);
        if(hashTabList[index] == null){
            hashTabList[index] = new EmpLinkedList();
        }
        hashTabList[index].add(emp);
    }

    public Employee findById(int id){
        int index = chooseLinkedList(id);
        if(hashTabList[index] == null){
            System.out.println("该员工信息不存在");
            return null;
        }
//        Arrays.asList(new int[10]).sort();
        return hashTabList[index].findByid(id);
    }

    public void listAll(){
        for(int i =0;i<size ;i++){
            if(hashTabList[i] == null){
                System.out.println("第"+(i+1)+"个链表为空");
            }else{
                hashTabList[i].list();
            }

        }
    }

    public int chooseLinkedList(int id){
        return id%size;
    }
}


