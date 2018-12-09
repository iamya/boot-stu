package my.spring.cloud.demo.eurekaconsumer.controller;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/username")
    public List<String> getUserName() {

        List<String> nameList = Lists.newArrayList();
        nameList.add("张三");
        nameList.add("李四");

        LOGGER.info("nameList: {}", nameList);

        return nameList;
    }


    @GetMapping("/username/{id}")
    public String getUserNameById(@PathVariable int id) {

        return "id : " + id + ", name : 张三";
    }


    @PostMapping("/username")
    public String save(@RequestParam("id") int id, @RequestParam("username") String  username) {

        return id + "==" + username;
    }
}
