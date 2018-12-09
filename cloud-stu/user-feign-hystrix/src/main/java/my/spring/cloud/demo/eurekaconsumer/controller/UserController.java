package my.spring.cloud.demo.eurekaconsumer.controller;

import my.spring.cloud.demo.eurekaconsumer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/username")
    public List<String> getUserName() throws InterruptedException {
        return userService.getUserName();
    }


    @GetMapping("/username/{id}")
    public String getUserNameById(@PathVariable int id) {
        return userService.getUserNameById(id);
    }


    @PostMapping("/username")
    public String save(@RequestParam("id") int id, @RequestParam("username") String username) {
        return userService.save(id, username);
    }
}
