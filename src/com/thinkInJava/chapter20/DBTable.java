package com.thinkInJava.chapter20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)   //进在类上声明
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
}
