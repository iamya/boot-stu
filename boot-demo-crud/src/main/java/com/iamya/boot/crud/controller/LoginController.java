package com.iamya.boot.crud.controller;

import com.iamya.boot.crud.exception.UserForbidException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map, HttpSession session) throws UserForbidException {

        if("aaa".equals(username)) {
            throw new UserForbidException();
        }

       if("123".equals(password)) {

           session.setAttribute("loginUser", username);
           return "redirect:/main.html";
       }

       map.put("msg", "用户名密码错误");
        return "index";
    }
}
