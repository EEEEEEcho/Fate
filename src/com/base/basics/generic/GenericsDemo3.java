package com.base.basics.generic;

public class GenericsDemo3 {

    /**
     * 声明静态泛型方法
     * @param c 用来创建泛型对象
     * @param <T> 声明此方法持有一个类型T，也可以理解为声明此方法为泛型方法
     * @return T 该方法的返回值类型为T类型
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> T getObject(Class<T> c) throws InstantiationException, IllegalAccessException {
        T t = c.newInstance();
        return t;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //此时的OBJ就是User类型
        Object object = getObject(Class.forName("com.base.basics.generic.User"));
        System.out.println(object);
    }
}
