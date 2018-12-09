package my.spring.cloud.demo.eurekaconsumer;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringCloudApplication
@EnableFeignClients
public class UserFeginHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserFeginHystrixApplication.class, args);
	}
}
