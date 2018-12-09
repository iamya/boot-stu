package com.iamya.bootdemo.service.impl;

import com.iamya.bootdemo.service.IAsyncDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AsyncDemoServiceImpl  implements IAsyncDemoService {

    @Async("asyncTaskExecutor")
    @Override
    public Future<String> sayHello(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("hello" + i);

        if(i == 4) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return new AsyncResult<>("hello" + i);
    }
}
