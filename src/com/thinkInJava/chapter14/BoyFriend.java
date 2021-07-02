package com.thinkInJava.chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class BoyFriend implements InvocationHandler {
    //因为是动态代理，所以在代理之前，并不知道代理的到底是哪个女朋友
    private Object girlFriend;

    public BoyFriend(Object girlFriend){
        this.girlFriend = girlFriend;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理的女朋友中定义的方法是:" + method.getName());
        System.out.println("代理的女朋友的方法中要传入的参数是:" + Arrays.toString(args));
        System.out.println("在代理女朋友买东西之前先要跟她要钱");
        return method.invoke(girlFriend,args);
    }
    public static void buy(GirlFriend girlFriend){
        girlFriend.buyMilkTea();
    }

    public static void main(String[] args) {
        MyGirlFriend myGirlFriend = new MyGirlFriend();
        buy(myGirlFriend);

        GirlFriend proxy = (GirlFriend) Proxy.newProxyInstance(
          GirlFriend.class.getClassLoader(),    //类加载器
          new Class[]{GirlFriend.class},        //代理人应该实现的接口
          new BoyFriend(myGirlFriend)
        );

        buy(proxy);
    }
}
