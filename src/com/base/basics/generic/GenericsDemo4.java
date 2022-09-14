package com.base.basics.generic;

import java.util.Iterator;
import java.util.List;

public class GenericsDemo4 {

    public static void main(String[] args) {
        SimpleInfo<String> stringSimpleInfo = new SimpleInfo<>();
        SimpleInfo<Integer> integerSimpleInfo = new SimpleInfo<>();
        SimpleInfo<Object> objectSimpleInfo = new SimpleInfo<>();
        print(stringSimpleInfo);
//        print(integerSimpleInfo); //编译错误
        print(objectSimpleInfo);
    }
    //该方法限定，传入的simpleInfo中的泛型参数只能是String及其父类型
    public static void print(SimpleInfo<? super String> simpleInfo){
        System.out.println(simpleInfo);
    }

    /**
     *  * // 为了获得最大限度的灵活性，要在表示生产者或者消费者的输入参数上使用通配符，使用的规则就是：生产者有上限、消费者有下限
     *  * 1. 如果参数化类型表示一个 T 的生产者，使用 < ? extends T>;
     *  * 2. 如果它表示一个 T 的消费者，就使用 < ? super T>；
     *  * 3. 如果既是生产又是消费，那使用通配符就没什么意义了，因为你需要的是精确的参数类型。
     * @param e1
     * @param <E>
     * @return
     */
    //E extends Comparable<? super E> E 是一个可比较的类，所以应该是Comparable接口的子类
    //Comparable<? super E> 要对E比较，所以是E的消费者， 需要用super。比较E和E的父类
    //List<? extends E> e1  表示要操作的数据是 E 的子类的列表，指定上限，这样容器才够大
    private  <E extends Comparable<? super E>> E max(List<? extends E> e1) {
        if (e1 == null){
            return null;
        }
        //迭代器返回的元素属于 E 的某个子类型
        Iterator<? extends E> iterator = e1.iterator();
        E result = iterator.next();
        while (iterator.hasNext()){
            E next = iterator.next();
            if (next.compareTo(result) > 0){
                result = next;
            }
        }
        return result;
    }
}
//只能传入Number及其子类的参数
class MoreInfo<T extends Number>{
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}


class SimpleInfo<T>{
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
/**
 * <?> 无限制通配符
 * <? extends E> extends 关键字声明了类型的上界，表示参数化的类型可能是所指定的类型，或者是此类型的子类
 * <? super E> super 关键字声明了类型的下界，表示参数化的类型可能是指定的类型，或者是此类型的父类
 *
 * // 为了获得最大限度的灵活性，要在表示生产者或者消费者的输入参数上使用通配符，使用的规则就是：生产者有上限、消费者有下限
 * 1. 如果参数化类型表示一个 T 的生产者，使用 < ? extends T>;
 * 2. 如果它表示一个 T 的消费者，就使用 < ? super T>；
 * 3. 如果既是生产又是消费，那使用通配符就没什么意义了，因为你需要的是精确的参数类型。
 */