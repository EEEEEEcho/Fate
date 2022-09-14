package com.interview.review;

/**
 * 泛型回忆
 */
public class Review1 {
    public static <T> T getInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        T t = clazz.newInstance();
        return t;
    }
}
