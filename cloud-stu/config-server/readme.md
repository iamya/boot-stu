说明:

uri与配置文件格式的对应关系如下:

/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties

访问例子:
http://localhost:9010/application/dev/master
http://localhost:9010/master/application-dev