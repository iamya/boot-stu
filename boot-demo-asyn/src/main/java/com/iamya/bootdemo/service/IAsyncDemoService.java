package com.iamya.bootdemo.service;

import java.util.concurrent.Future;

public interface IAsyncDemoService {

   Future<String> sayHello(int i);
}
