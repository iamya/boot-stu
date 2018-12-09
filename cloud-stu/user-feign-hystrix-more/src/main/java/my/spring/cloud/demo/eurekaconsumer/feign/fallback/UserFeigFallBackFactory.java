package my.spring.cloud.demo.eurekaconsumer.feign.fallback;

import com.google.common.collect.Lists;
import feign.hystrix.FallbackFactory;
import my.spring.cloud.demo.eurekaconsumer.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFeigFallBackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFeigFallBackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {

        LOGGER.info("fallback; reason was: {}", cause.getMessage());

        return new UserFeignClient() {
            @Override
            public List<String> getUserName() {
                return Lists.newArrayList("fallback", "factory", "run");
            }

            @Override
            public String getUserNameById(int id) {
                return "fallbackfatory run " + id;
            }

            @Override
            public String save(int id, String username) {
                return "fallbackfactory run ok";
            }
        };
    }
}
