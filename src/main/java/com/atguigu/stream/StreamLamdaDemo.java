package com.atguigu.stream;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class StreamLamdaDemo {
    public static void main(String[] args) {
        User user1 = new User("a", 10, 0);
        User user2 = new User("b", 8, 1);
        User user3 = new User("c", 17, 0);
        User user4 = new User("d", 21, 1);
        User user5 = new User("e", 3, 0);

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5);

        users.stream().filter(u->{return u.age > 5;})
                .map(u->{return u.getName().toUpperCase();})
                .sorted((u1,u2)->{return u2.compareTo(u1);})
//                .limit(3)
                .forEach(System.out::println);
    }
}


class User{
    public User(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;
    public int age;
    public int sex;
}
