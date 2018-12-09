package com.iamya.bootdemo.controller;

import com.iamya.bootdemo.service.IAsyncDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@RestController
public class AsyncDemoController {

    @Autowired
    IAsyncDemoService asyncDemoService;

    @GetMapping("/hello")
    public String hello() {

        log.info("1");
        long a = System.currentTimeMillis();
        // Future<String> future = asyncDemoService.sayHello(1);
        List<Future<String>> futures = new ArrayList<>();
        Future<String> future;
        for (int i = 0; i < 15; i++) {
            future = asyncDemoService.sayHello(i);
            futures.add(future);
        }
        List<String> result = new ArrayList<>();
        try {
            for (Future<String> stringFuture : futures) {
                String s = null;
                s = stringFuture.get();
                result.add(s);
            }
        } catch (InterruptedException e) {
            log.error("future error:", e);
            return e.getMessage();
        } catch (ExecutionException e) {
            log.error("future error:", e);
            return e.getMessage();
        }
        log.info("2");
        log.info("time:" + (System.currentTimeMillis() - a));
        return result.toString();
    }

}
