package com.code.ProxyDemo;

public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String msg) {
        System.out.println("send msg : " + msg);
        return msg;
    }
}
