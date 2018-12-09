package my.spring.cloud.demo.eurekaconsumer.service.impl;


import my.spring.cloud.demo.eurekaconsumer.feign.UserFeignClient;
import my.spring.cloud.demo.eurekaconsumer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public List<String> getUserName() {
        return userFeignClient.getUserName();
    }

    @Override
    public String getUserNameById(int id) {
        return userFeignClient.getUserNameById(id);
    }

    @Override
    public String save(int id, String username) {
        return userFeignClient.save(id, username);
    }

}
