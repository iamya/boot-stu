package my.spring.cloud.demo.eurekafeign.feignclient;

import feign.RequestLine;
import my.spring.cloud.demo.config.UserConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.List;

@FeignClient(name = "user-client", configuration = UserConfiguration.class)
public interface UserClient {

    @RequestLine(value = "GET /username")
    public List<String> getUserName();


//    public String getUserNameById(@PathVariable int id);
//
//
//    public String save(@RequestParam("id") int id, @RequestParam("username") String  username);
}
