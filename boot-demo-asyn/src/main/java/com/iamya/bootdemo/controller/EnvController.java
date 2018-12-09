package com.iamya.bootdemo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {

    @Value("${name}")
    private String name;

    /**
     * 配置文件读取: 指定环境(appliction-test.yml)覆盖默认环境(application.yml)
     * @return
     */
    @GetMapping("/name")
    public String getName() {
        return name;
    }

}
