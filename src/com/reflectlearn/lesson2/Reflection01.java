package com.reflectlearn.lesson2;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
    public static void main(String[] args) throws Exception{
        //1.使用Properties类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\com\\reflectlearn\\lesson1\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();

        //(1)加载类
        Class<?> clazz = Class.forName(classfullpath);
        //(2)通过clazz得到加载的类com.reflectlearn.lesson1.Cat的对象实例
        Object o = clazz.newInstance();
        System.out.println("o 的运行时类型" + o.getClass());   //获取对象的运行时类型
        //(3)通过clazz得到加载的类com.reflectlearn.lesson1.Cat的 methodName 的 方法 对象
        //即：在反射中，把方法视为一个对象  万物皆对象
        Method method = clazz.getMethod(methodName);
        //(4)通过method调用方法：即通过方法对象来实现调用方法
        System.out.println("****************");
        method.invoke(o);   //传统方法：对象.方法(), 反射机制：方法.invoke(对象)
    }
}
