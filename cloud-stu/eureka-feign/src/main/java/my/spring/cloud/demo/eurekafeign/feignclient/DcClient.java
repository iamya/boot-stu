package my.spring.cloud.demo.eurekafeign.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("eureka-client")
public interface DcClient {

    @GetMapping("/dc")
    public List<String> consumer();

}
