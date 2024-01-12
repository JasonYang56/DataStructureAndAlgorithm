package com.atguigu.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        personList.stream().filter(p->p.getSalary()>8000).map(p ->{return p.getName();}).collect(Collectors.toList()).forEach(System.out::println);

        //获取名字最长的
        Optional<String> max = personList.stream().map(p -> p.getName()).max(Comparator.comparing(String::length));
        System.out.println("名字最长的----->"+max.get());

        //获取最高工资
        Optional<Person> max1 = personList.stream().max(Comparator.comparing(Person::getSalary));
        System.out.println("最高工资----->"+max1.get().getSalary());
        //获取最高工资人名字
        System.out.println("最高工资人名字----->"+max1.get().getName());

        Map<String, Integer> collect = personList.stream().filter(p -> p.getSalary() > 8000).collect(Collectors.toMap(Person::getName, Person::getSalary));
        System.out.println("===========================");

        collect.forEach((s, integer) ->{
            System.out.println(s+"---->"+integer);
        } );


        Map<String, Map<String, List<Person>>> collect1 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));

    }
}


class Person {
    private String name;  // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area;  // 地区
    // 构造方法
    public Person(String name, int salary, int age,String sex,String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }
    // 省略了get和set，请自行添加

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}