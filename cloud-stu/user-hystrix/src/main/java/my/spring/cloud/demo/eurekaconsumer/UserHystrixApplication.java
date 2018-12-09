package my.spring.cloud.demo.eurekaconsumer;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker
@SpringCloudApplication //该注解就是上面三个注解的整合注解
@EnableFeignClients
public class UserHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserHystrixApplication.class, args);
	}
}
