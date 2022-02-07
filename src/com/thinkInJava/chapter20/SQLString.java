package com.thinkInJava.chapter20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
    int value() default 0;  // 该元素用来规定数据库应该给被注解的变量设置多少大小
    String name() default "";
    //注解嵌套，constraints元素的默认值是@Constraints,实际上是一个所有元素都为默认值的
    //@Constraints值，因为没有加参数，
    Constraints constraints() default @Constraints;
}
