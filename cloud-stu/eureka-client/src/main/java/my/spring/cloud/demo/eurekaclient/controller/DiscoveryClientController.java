package my.spring.cloud.demo.eurekaclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscoveryClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscoveryClientController.class);

    @GetMapping("/dc")
    public List<String> dc() {

        List<String> services = discoveryClient.getServices();

        LOGGER.info("[注册方法:] {}", services);

        return services;
    }
}
