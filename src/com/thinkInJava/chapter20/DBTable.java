package com.thinkInJava.chapter20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)   //仅在类上声明
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    //该元素用来为数据库表创建名字
    public String name() default "";
}
