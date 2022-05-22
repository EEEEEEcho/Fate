package com.base.basics.generic;

public class GenericsDemo2 {
    public static void main(String[] args) {
        Info<String> info = new InfoImpl<>("TOM");
        System.out.println(info.getVar());
    }
}
interface Info<T>{
    public T getVar();
}
class InfoImpl<T> implements Info<T>{
    private T var;

    public InfoImpl(T var){
        this.setVar(var);
    }

    @Override
    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
}
