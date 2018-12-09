package my.spring.cloud.demo.eurekaconsumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("user-client")
public interface UserFeignClient {

    @GetMapping("/username")
    public List<String> getUserName();


    @GetMapping("/username/{id}")
    public String getUserNameById(@PathVariable("id") int id);


    @PostMapping("/username")
    public String save(@RequestParam("id") int id, @RequestParam("username") String username);
}
