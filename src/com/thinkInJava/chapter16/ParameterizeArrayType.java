package com.thinkInJava.chapter16;
class ClassParameter<T> {
    public T[] t(T[] arg){
        return arg;
    }
}
class MethodParameter{
    public static <T> T[] f(T[] arg){
        return arg;
    }
}
public class ParameterizeArrayType {
    public static void main(String[] args) {
        Integer[] ints = {1,2,3,4,5};
        Double[] doubles = {1.1,2.2,3.3,4.4,5.5,6.6};
        Integer[] ints2 = new ClassParameter<Integer>().t(ints);
        Double[] doubles2 = new ClassParameter<Double>().t(doubles);
        ints2 = MethodParameter.f(ints);
        doubles2 = MethodParameter.f(doubles);
    }
}
