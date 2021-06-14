package com.genericlearn.demo04;

/**
 * 从泛型类派生子类有两种情况
 * 1.子类也是泛型类，子类和父类的泛型类型要一直
 * class ChildGeneric<T> extends Generic<T>
 * 2.子类不是泛型类，父类要明确泛型的数据类型
 * class ChildGeneric extends Generic<String>
 * @param <E>
 */
public class Parent<E> {
    private E value;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
