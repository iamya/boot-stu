package my.spring.cloud.demo.eurekafeign.controller;

import my.spring.cloud.demo.eurekafeign.feignclient.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscoveryClientController {

    @Autowired
    private DcClient dcClient;

    @GetMapping("/consumer")
    public List<String> dc() {

        return dcClient.consumer();
    }
}
