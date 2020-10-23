package com.thinkInJava.chapter17;

import com.thinkInJava.chapter15.Generator;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionData<T> extends ArrayList<T> {
    //使用Generator构造器在容器中放置所需数量的对象
    public CollectionData(Generator<T> gen,int quantity){
        for(int i=0;i < quantity;i ++){
            //因为继承自ArrayLists,所以内置有add方法
            add(gen.next());
        }
    }
    //所产生的容器可以传递给任何Collection容器
    public static <T> CollectionData<T> list(Generator<T> gen,int quantity){
        return new CollectionData<T>(gen,quantity);
    }
}
