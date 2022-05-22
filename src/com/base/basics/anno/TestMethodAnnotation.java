package com.base.basics.anno;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestMethodAnnotation {
    @Override
    @MyMethodAnnotation(title = "toStringMethod", description = "override toString method")
    public String toString() {
        return "Override toString method";
    }

    @Deprecated
    @MyMethodAnnotation(title = "old static method", description = "deprecated old static method")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MyMethodAnnotation(title = "test method", description = "suppress warning static method")
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }

    public static void main(String[] args) {
        //TestMethodAnnotation中的所有方法
        Method[] methods = TestMethodAnnotation.class.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyMethodAnnotation.class)){
                try {
                    //获取并遍历方法上的所有注解
                    for (Annotation annotation : method.getDeclaredAnnotations()){
                        System.out.println("Annotation in Method '"
                                + method + "' : " + annotation);
                    }

                    //获取MyMethodAnnotation对象信息
                    MyMethodAnnotation myMethodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
                    System.out.println(myMethodAnnotation.title());
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
