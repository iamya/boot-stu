说明:

1. @SpringCloudApplication注解的使用:等同于springbootApplication + enableDiscoveryClient + EnableCircuitBreaker;

2. 本例中使用feign和hystrix的分开使用,在要实现的方法上面提供降级回退方法.当userfeignclient中服务挂掉之后执行fallback方法.


3.     @HystrixCommand(fallbackMethod = "fallbackMethodName", commandProperties = {
               @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
       })
      
  这个注解可以使降级方法在同一线程中执行(默认回退方法是在新线程中执行)   
  
4. 可以在服务暴露的端口中加入"/health"来检测hystrix的健康状态,可以加入"/hystrix.stream"来检测服务调用状态.