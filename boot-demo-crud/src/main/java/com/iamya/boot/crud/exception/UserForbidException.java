package com.iamya.boot.crud.exception;

public class UserForbidException extends Exception {

    public UserForbidException() {
        super("该用户被禁止登录");
   }
}
