package com.test;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(2,10);
        for (int i = 0; i < 20; i++) {
            int k = i;
            threadPool.execute(() -> {
                System.out.println("任务" + k);
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
//任务队列
class BlockingQueue<T>{
    //放置任务的容器
    private ArrayDeque<T> arrayDeque = new ArrayDeque<>();
    //锁
    private ReentrantLock lock = new ReentrantLock();
    //条件变量
    private Condition consumer = lock.newCondition();
    private Condition producter = lock.newCondition();
    //队列大小
    private int size;
    public BlockingQueue(int size){
        this.size = size;
    }
    //向队列中添加元素
    public void offer(T t){
        //先加锁
        lock.lock();
        try {
            //当队列满的时候，进入full中等待
            while (arrayDeque.size() == this.size){
                try {
                    producter.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //否则，队列不满
            arrayDeque.offer(t);
            //唤醒消费者
            consumer.signalAll();
        }
        finally {
            //解锁
            lock.unlock();
        }
    }
    //从队列中取出元素
    public T poll(){
        //加锁
        lock.lock();
        try{
            //队列中为空，等待
            while (arrayDeque.isEmpty()){
                try {
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = arrayDeque.poll();
            //唤醒生产者
            producter.signalAll();
            return t;
        }
        finally {
            lock.unlock();
        }
    }
}

//线程池
class ThreadPool{
    //提交的任务队列
    private BlockingQueue<Runnable> taskQueue;
    //工作的线程集合
    private HashSet<Worker> workers;
    //线程池的核心线程数
    private int coreSize;
    public ThreadPool(int coreSize,int queueSize){
        this.coreSize = coreSize;
        this.taskQueue = new BlockingQueue<>(queueSize);
        this.workers = new HashSet<Worker>();
    }

    public void execute(Runnable task){
        //执行任务，提交任务时可能会创建工作线程，需要对工作线程队列加锁
        synchronized (workers){
            //如果当前工作线程数小于传入的工作线程数量
            if(workers.size() < this.coreSize){
                //创建一个工作线程
                Worker worker = new Worker(task);
                //加入到集合中
                workers.add(worker);
                //启动线程
                worker.start();
            }
            //否则的话，证明线程池的工作线程达到最大了
            else{
                //将任务加入等待队列
                taskQueue.offer(task);
            }
        }
    }

    //工作线程
    class Worker extends Thread{
        //工作线程中要有任务
        private Runnable task;
        public Worker(Runnable runnable){
            this.task = runnable;
        }
        //线程工作
        @Override
        public void run() {
            //如果传入的工作不为空，或者工作队列中仍有任务，那么就已知循环
            while ((task != null) || ((task = taskQueue.poll()) != null)){
                try {
                    task.run();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    //最后要把task置为null,结束循环
                    task = null;
                }
            }
            //如果没有任务了,从工作线程集合中移除该线程
            synchronized (workers){
                workers.remove(this);
            }
        }
    }
}