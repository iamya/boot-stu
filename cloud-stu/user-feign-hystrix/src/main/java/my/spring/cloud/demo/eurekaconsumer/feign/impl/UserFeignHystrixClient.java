package my.spring.cloud.demo.eurekaconsumer.feign.impl;

import com.google.common.collect.Lists;
import my.spring.cloud.demo.eurekaconsumer.feign.UserFeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFeignHystrixClient implements UserFeignClient{


    public List<String> getUserName() {
        return Lists.newArrayList("Hystrix", "fallback", "method", "run");
    }


    public String getUserNameById(int id) {
        return "Hystrix-feign-fallback : " + id;
    }


    public String save(int id, String username) {
        return "Hystrix-feign-fallback save";
    }
}
