package com.genericlearn.demo09;

import java.util.List;

public class EraserLimit <T extends Number>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "EraserLimit{" +
                "t=" + t +
                '}';
    }

    /**
     * 定义了一个泛型方法
     * @param e
     * @param <E>
     * @return
     */
    public <E extends List> E show(E e){
        return e;
    }
}
