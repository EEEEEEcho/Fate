package com.thinkInJava.chapter20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    //是否主键
    boolean primaryKey() default false;
    //是否可以为空
    boolean allowNull() default true;
    //是否唯一
    boolean unique() default false;
}
