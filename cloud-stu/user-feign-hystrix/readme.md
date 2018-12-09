说明:

1. 在userService里面会报错误,但是程序可以启动.

2. feign的hystrix支持可能是默认关闭的,必须手动配置:feign.hystrix.enabled = true(视频学习中是默认开启,可能由于学习版本不同) 