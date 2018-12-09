package my.spring.cloud.demo.eurekafeign;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EurekaFeignMoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignMoreApplication.class, args);
	}
}
