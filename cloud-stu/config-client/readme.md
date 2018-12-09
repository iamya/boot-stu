说明:

1.配置文件的加载顺序:bootstrap.* -->configclient --> applicatoion.* ,而bootstrap里面默认对spring.cloud.config.uri的配置是localhost:8888,
所以不在bootstrap.*里面修改的话,是读不到configserver里面的文件的.

2.在这三个文件中,只要配置文件中读取到一个值,bean完成初始化之后后面再次出现的相同的value就不会读取.
