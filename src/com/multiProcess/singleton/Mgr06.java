package com.multiProcess.singleton;

/**
 * 使用双重判断来解决线程不安全的懒汉式问题
 */
public class Mgr06 {
    private static volatile Mgr06 INSTANCE;
    private Mgr06(){

    }
    public static Mgr06 getInstance(){
        //业务逻辑代码。。。
        if(INSTANCE == null){
            synchronized (Mgr06.class){
                if(INSTANCE == null){
                    try{
                        Thread.sleep(1);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }
    public void m(){
        System.out.println("mmmmmmmmmmmm");
    }

    public static void main(String[] args) {
        for (int i = 0;i < 100;i ++){
            new Thread(()->{
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
        //这样的运行结果，不加volatile 基本是没问题的，但是，要不要对private static Mgr06 INSTANCE; 加volatile?
        //答案是要加的 private static volatile Mgr06 INSTANCE;
        //如果不加，会出指令重排序问题
        //INSTANCE = new Mgr06(); 这句代码执行时是有三步的。
        // 1. 给对象申请内存，并把其中的成员变量初始化为一个默认的值，举例来说，如果有一个int类型的成员变量，则赋值为0
        // 2. 初始化对象的成员变量 把成员变量赋值为代码中设的值，如8  a=8
        // 3. 将栈中的指针指向这个对象。在这里就是INSTANCE 指向初始化的 new Instance()
        // 但是经历了指令重排序之后，可能第二步 和第三步就换位置了，就是说，在初始化完默认值之后
        // 就将指针指向了成员变量。这时成员变量还没有真正赋值
        // 所以，就会出现这样的问题。在超高并发的情况下，
        // 第一个线程拿到了锁，然后判断对象确实为空，加锁开始初始化。然后
        // 虚拟机执行这段代码，才初始化到一半，也就是new到一半的时候 （因为并发量超高）
        // 指令重排序发生了，在初始化成默认值的时候，就将INSTANCE指向了它，这时候INSTANCE并不为空，但是还没有被真正赋值。
        // 然后第二个线程来了，判断INSTANCE并不为空，直接就拿到了这个并没有赋值的INSTANCE

        //然而，对成员变量加了volatile 就禁止了指令重排序，就不会发生这种情况，
    }
}

