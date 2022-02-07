package com.genericlearn.demo04;

/**
 * 泛型类派生子类，子类也是泛型类，那么子类的泛型标识要和父类的一致
 * @param <T>
 */
//这里父类的泛型标识不能指定为定义时的E，父类中传递的泛型标识要和子类中的相同
public class ChildFirst<T> extends Parent<T> {
    @Override
    public T getValue() {
        return super.getValue();
    }
}
