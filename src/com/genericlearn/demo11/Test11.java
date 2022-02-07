package com.genericlearn.demo11;

import java.lang.reflect.Constructor;

public class Test11 {
    /**
     * 泛型与反射
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor();
        //创建对象
        Person person = constructor.newInstance();


        Class aClass = Person.class;
        Constructor constructor1 = aClass.getConstructor();
        Object o = constructor1.newInstance();
    }
}
