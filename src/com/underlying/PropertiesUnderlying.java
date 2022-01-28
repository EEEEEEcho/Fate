package com.underlying;

import java.util.Properties;

public class PropertiesUnderlying {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("john",100);
        //properties.put(null,100); Exception
        //properties.put("john",null); Exception
        properties.put("lucky",100);
        properties.put("lic",100);
        properties.put("lic",80);
        System.out.println(properties);

        //1.通过key获取相应的值
        System.out.println(properties.get("lic"));
        System.out.println(properties.getProperty("lic"));
        //2.删除
        properties.remove("lic");
        System.out.println(properties);
        //3.修改
        properties.put("john",200);
        System.out.println(properties);
    }
}
