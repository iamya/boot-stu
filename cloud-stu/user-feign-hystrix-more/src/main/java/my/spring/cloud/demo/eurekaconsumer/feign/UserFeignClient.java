package my.spring.cloud.demo.eurekaconsumer.feign;

import my.spring.cloud.demo.eurekaconsumer.feign.fallback.UserFeigFallBackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-client", fallbackFactory = UserFeigFallBackFactory.class)
public interface UserFeignClient {

    @GetMapping("/username")
    List<String> getUserName();


    @GetMapping("/username/{id}")
    String getUserNameById(@PathVariable("id") int id);


    @PostMapping("/username")
    String save(@RequestParam("id") int id, @RequestParam("username") String username);
}
