package com.genericlearn.demo05;

/**
 * 实现泛型接口的类不是泛型类，这时需要明确实现泛型接口的数据类型
 */
public class Apple implements Geneator<String>{
    //如果不指定泛型类型，将会按Object来处理
    //public class Apple implements Geneator
//    @Override
//    public Object getKey() {
//        return null;
//    }

    @Override
    public String getKey() {
        return "Hello Generic";
    }
}
