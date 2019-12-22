package com.yangxiaolong.dfal.Java并发编程实战.d5;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

public class Thread05 {
    /**
     * Semaphore 信号量
     * 1.信号量模型 一个计数器 一个等待队列 三个方法
     * Init() up() down()
     * down:计数器减1;如果此时计数器的值小于0,则线程被阻塞,否则可以继续执行
     * up(): 计数器加1,如果计数器的值小于等于0,则唤醒等待队列的线程,并将其从等待队列中移除
     *  整个操作过程中不会被线程调度器中断的操作，都可认为是原子性
     *
     *  2.信号量实现锁的原理
     *  两个线程同时进入访问addOne方法,同时调用acquire,由于信号量的原子性,所以只有一个线程进入
     *  计数器为1,则当线程1进入时,执行计数器-1=0 线程通行 线程2执行,计数器=-1,则线程阻塞,进入等待队列
     *  当T1执行release时,此时信号量计数器value=-1+1=0,此时唤醒T2,于是T2在线程1执行完后才能进入临界区
     *
     *  3.基于Semaphore的限流器
     *  可以允许多个线程访问临界区 -->对象池 和 连接池 线程池
     *
     */
}
class Semaphore01{
    static int count;
    //初始化信号量
    static final Semaphore s= new Semaphore(1);
    //用信号量保证互斥
    static void addOne(){
        try {
            /**
             * 两个线程同时进入访问addOne方法,同时调用acquire,由于信号量的原子性,所以只有一个线程进入
             * 计数器为1,则当线程1进入时,执行计数器-1=0 线程通行 线程2执行,计数器=-1,则线程阻塞,进入等待队列
             * 当T1执行release时,此时信号量计数器value=-1+1=0,此时唤醒T2,于是T2在线程1执行完后才能进入临界区
             *
             */
            s.acquire();
            //临界区
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            s.release();
        }

    }
    class ObjPool<T,R>{
       final List<T> pool;
       final Semaphore sem;
       //构造方法
        ObjPool(int size,T t){
            pool=new Vector<T>(){};
            for (int i = 0; i < size; i++) {
                pool.add(t);
            }
            sem=new Semaphore(size);
        }
        //利用对象池中的对象,调用func;
        R exec(Function<T,R> func){
            T t=null;
            try {
                sem.acquire();
                t=pool.remove(0);
                return func.apply(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                pool.add(t);
                sem.release();
            }
            return null;
        }

    }


}