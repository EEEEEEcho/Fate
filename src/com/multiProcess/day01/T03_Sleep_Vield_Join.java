package com.multiProcess.day01;

public class T03_Sleep_Vield_Join {
    public static void main(String[] args) {
        //testYield();
        testJoin();
    }

    static void testSleep(){
        new Thread(()->{
            for (int i=0;i < 100;i ++){
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);  //线程sleep之后将CPU使用权交给其他线程，相当于挂起
                }
                catch (InterruptedException e){
                    // 这个InterruptedException 如果一个线程被打断，那么线程被打断之后会捕获到这个异常。
                    // 但是捕获到这个异常之后，并不意味着线程终止，如果决定终止，则在捕获这个异常之后可以将此
                    // 线程终止。但是如果不处理，线程继续运行。
                    // 但是 不要使用线程的stop方法强制使线程终止
                    // Interrupted 一般
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static void testYield(){
        /**
         * 线程调用yield，线程会临时退出，进入等待队列，
         * 其实就是从运行态转换为就绪态，重新竞争cpu
         */
        new Thread(()->{
            for (int i=0;i < 100;i ++){
                System.out.println("A" + i);
                if(i % 10 == 0){
                    Thread.yield();
                }
            }
        }).start();
        new Thread(()->{
            for (int i=0;i < 100;i ++){
                System.out.println("B*********" + i);
                if(i % 10 == 0){
                    Thread.yield();
                }
            }
        }).start();
    }

    static void testJoin(){
        /**
         * 在线程t2中调用t1.join。这时会将cpu使用权交给t1
         * t1运行完成后，t2获得cpu使用权继续运行。
         * join方法经常用来等待线程结束
         */
        Thread t1 = new Thread(()->{
            for(int i=0;i < 100;i ++){
                System.out.println("A" + i);
                try {
                    System.out.println("我运行了");
                    Thread.sleep(500);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        //t1.start();
        Thread t2 = new Thread(()->{
            try {
                System.out.println("t2正在运行");
                t1.join();
                System.out.println("t1运行完了。我继续运行");
//                while (true){
//                    System.out.println("HHH");
//                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();

    }
}
