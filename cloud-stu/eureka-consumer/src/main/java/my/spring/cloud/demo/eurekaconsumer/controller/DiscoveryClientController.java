package my.spring.cloud.demo.eurekaconsumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DiscoveryClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscoveryClientController.class);

    @GetMapping("/consumer")
    public String dc() {

        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");

        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";

        LOGGER.info("[url:] {}", url);

        return restTemplate.getForObject(url, String.class);
    }

}
