package com.multiProcess.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile 并不能保证原子性，不能替代synchronized
 */
public class T02_Volatile_test02 {
    volatile int count = 0;
    void m(){
        for(int i=0;i < 10000;i ++){
            count++;
        }
    }

    public static void main(String[] args) {
        T02_Volatile_test02 test02 = new T02_Volatile_test02();
        List<Thread> threads = new ArrayList<>();
        for(int i=0;i < 10;i ++){
            threads.add(new Thread(test02::m,"thread-" + i));
        }
        threads.forEach((o)->o.start());
        threads.forEach((o) -> {
            try {
                o.join();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        System.out.println(test02.count);
    }
}
