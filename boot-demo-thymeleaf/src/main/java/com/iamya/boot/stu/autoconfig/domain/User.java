package com.iamya.boot.stu.autoconfig.domain;


import java.io.Serializable;

public class User implements Serializable{


    private String username;

    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

