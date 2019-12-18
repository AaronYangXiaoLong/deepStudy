package com.yangxiaolong.dfal.Java并发编程实战.d4;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author YXL
 * @date 2019/12/18 16:03
 */
public class Thread04 {
    /**
     * 基础知识补充:
     * 独占锁有两种 synchronized 和 ReentrantLock -->更加适合复杂的并发场景. synchronized是隐式的锁,无需加锁和解锁
     * 而Reentrantlock在重入时需要保证获取锁的次数和解锁的次数必须相同
     * ReenteantLock 在创建时可以传入参数true或者false-->来创建公平锁,大部分情况下我们使用非公平锁，因为其性能比公平锁好很多。但是公平锁能够避免线程饥饿，某些情况下也很有用。
     * ReentrantLock是可重入的独占锁。比起synchronized功能更加丰富，支持公平锁实现，支持中断响应以及限时等待等等。可以配合一个或多个Condition条件方便的实现等待通知机制。
     *
     * Lock和Condition 并发包中的管程
     * Lock 对于不可抢占,占用部分资源的线程进一步申请其他资源时,如果申请不到,主动释放它占有的资源
     * synchronized 存在的问题就是持有A锁,尝试锁B失败,那么线程就进入阻塞
     * 1.响应中断
     * 给阻塞的线程发送中断信号,唤醒他,它有机会释放曾经持有的锁A
     * lockInterruptibly()
     * 2.支持超时
     * 一段时间里没有获取锁,不是进入阻塞而是返回错误
     * 3.非阻塞的获取锁
     * 尝试获取锁失败不进入阻塞则直接返回
     *
     *
     */
    //ReentrantLock 类的一些介绍及其方法
    /**
     * 构造方法 创建本身实例 传入参数(fair)创建给定的公平策略
     *
     */
}

class ThreadTest04 implements Lock {


    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

class X {

    private final Lock rt1 = new ReentrantLock();

    int value;

    public void add() {
        rt1.lock();

        try {
            value++;
        } finally {
            rt1.unlock();
        }
    }
}
