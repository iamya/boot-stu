package my.spring.cloud.demo.eurekaconsumer.service;

import java.util.List;

public interface IUserService {

    public List<String> getUserName();

    public String getUserNameById(int id);

    public String save(int id, String username);
}
