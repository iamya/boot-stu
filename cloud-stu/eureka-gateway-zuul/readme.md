说明:

1. zuul自身要注册到eureka上面

2. 配置
zuul:
     ignoredServices: '*'  #表示不反向代理的服务,'*'表示全部,如果不配置,默认可以通过 ZUUL_IP:ZUUL_PORT/service-name/request-url访问到
     routes:
       user-client: /user/**  #反向代理映射, 配置之后ZUUL_IP:ZUUL_PORT/user/request-url = ZUUL_IP:ZUUL_PORT/user-client/request-url
       