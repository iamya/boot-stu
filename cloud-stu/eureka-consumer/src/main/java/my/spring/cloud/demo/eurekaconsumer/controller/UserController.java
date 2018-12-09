package my.spring.cloud.demo.eurekaconsumer.controller;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/username")
    public List<String> getUserName() {

        return restTemplate.getForObject("http://localhost:9008/username", List.class);
    }


    @GetMapping("/username/{id}")
    public String getUserNameById(@PathVariable int id) {

        return restTemplate.getForObject("http://localhost:9008/username/" + id, String.class);
    }


    @PostMapping("/username")
    public String save(@RequestParam("id") int id, @RequestParam("username") String username) {

        Map<String, Object> requestMap = Maps.newHashMap();
        requestMap.put("id", id);
        requestMap.put("username", username);
//        restTemplate发送对象的post请求方式错误,暂不研究
//        return restTemplate.postForObject("http://localhost:9008/username", requestMap, String.class);
        return null;
    }
}
