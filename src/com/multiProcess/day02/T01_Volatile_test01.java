package com.multiProcess.day02;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class T01_Volatile_test01 {
    //boolean running = true; 这样的话，在main方法中就算设置running=false也不能停止程序
    volatile boolean running = true;    //但是 加了volatile关键字就不一样了

    /**
     * volatile 关键字的作用：1.保证线程可见性， 2.禁止指令重排序
     * 什么是保证线程可见性？
     * 首先，对象创建是在堆上的，所以会在堆上给 running这个实例变量分配一块内存
     * 但是 我们启动了两个线程，一个是主线程main 另一个是线程t1
     * t1执行 m 方法，而main对对象中的running进行修改，
     * 如果不加volatile,那么 主线程对running进行修改后会将修改结果写回堆中，但是t1执行的m()方法也要访问
     * 堆中的running变量。主线程写回了，但是t1线程不知道什么时候running变量发生改变了，它不知道什么时候读
     * 因此，t1就停不下来。
     * 但是加了volatile之后，这个running变量对线程就是可见了。主线程中对其进行了修改。t1线程就能够发现它被改变了。
     * 就可以立即进行停止。
     * volatile原理:为了提高处理器的执行速度，在处理器和内存之间增加了多级缓存来提升。但是由于引入了多级缓存，就存在
     * 缓存数据不一致问题。但是，对于volatile变量，当对volatile变量进行写操作的时候，JVM会向处理器发送一条lock前缀
     * 的指令，将这个缓存中的变量回写到系统主存中。但是就算写回到内存，如果其他处理器缓存的值还是旧的，再执行计算操
     * 作就会有问题，所以在多处理器下，为了保证各个处理器的缓存是一致的，就会实现缓存一致性协议
     * 缓存一致性协议：每个处理器通过嗅探在总线上传播的数据来检查自己缓存的值是不是过期了，当处理器发现自己缓存行对
     * 应的内存地址被修改，就会将当前处理器的缓存行设置成无效状态，当处理器要对这个数据进行修改操作的时候，会强制重
     * 新从系统内存里把数据读到处理器缓存里。
     * 所以，如果一个变量被volatile所修饰的话，在每次数据变化之后，其值都会被强制刷入主存。而其他处理器的缓存由于
     * 遵守了缓存一致性协议，也会把这个变量的值从主存加载到自己的缓存中。这就保证了一个volatile在并发编程中，其值
     * 在多个缓存中是可见的。
     * 禁止指令重排序？
     *
     */
    public void m(){
        System.out.println("m start..");
        while (running){

        }
        System.out.println("m end..");
    }
    public static void main(String[] args) {
        T01_Volatile_test01 test01 = new T01_Volatile_test01();
        new Thread(test01::m,"t1").start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        test01.running = false;
    }
}
