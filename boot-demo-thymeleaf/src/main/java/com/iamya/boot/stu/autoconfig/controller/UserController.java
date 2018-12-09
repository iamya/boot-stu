package com.iamya.boot.stu.autoconfig.controller;

import com.iamya.boot.stu.autoconfig.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/users")
    public String getUsers(Map<String, Object> map) {

        List<User> users = new ArrayList<>();

        users.add(new User("张三", 12));
        users.add(new User("李四", 13));

        map.put("users", users);
        map.put("hello", "HELLO,THYMELEAF");
        return "users";
    }
}
