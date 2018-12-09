package my.spring.cloud.demo.eurekafeign.controller;

import my.spring.cloud.demo.eurekafeign.feignclient.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/username")
    public List<String> getUserName() {

        return userClient.getUserName();
    }

}
