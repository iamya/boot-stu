package my.spring.cloud.demo.eurekaconsumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import my.spring.cloud.demo.eurekaconsumer.feign.UserFeignClient;
import my.spring.cloud.demo.eurekaconsumer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    @HystrixCommand(fallbackMethod = "getUserNameFallBack")
    public List<String> getUserName() {
        return userFeignClient.getUserName();
    }

    public List<String> getUserNameFallBack() {
        return new ArrayList<String>();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getUserNameByIdFallBack")
    public String getUserNameById(int id) {
        return userFeignClient.getUserNameById(id);
    }

    public String getUserNameByIdFallBack(int id) {
        return "0";
    }

    @Override
    @HystrixCommand(fallbackMethod = "saveFallBack")
    public String save(int id, String username) {
        return userFeignClient.save(id, username);
    }

    public String saveFallBack(int id, String username) {
        return "save failed";
    }
}
