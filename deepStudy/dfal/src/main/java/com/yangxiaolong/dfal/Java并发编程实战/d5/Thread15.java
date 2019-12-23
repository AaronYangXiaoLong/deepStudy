package com.yangxiaolong.dfal.Java并发编程实战.d5;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Thread15 {
    /**
     * ReadWriteLock:如何快速实现一个完备的缓存
     * 1.读写锁规则
     * 允许多个线程同时读共享变量 只允许一个线程写共享变量 如果一个线程正在写,禁止其他线程读
     *
     * 2.读写锁的实现 final ReadWriteLock rwl=new ReentrantReadWriteLock()
     *
     * 3.读写锁的升级和降级
     * 读锁升级到写锁:导致写锁的永久等待,最终导致相关线程的阻塞,永远没有机会唤醒
     * 写锁降级为读锁:这是可以的
     * 写锁支持条件变量,读锁不支持条件变量
     *
     */
}
class Cache<K,V>{
    final Map<K,V> m=new HashMap<>();
    final ReadWriteLock rwl=new ReentrantReadWriteLock();
    //创建读锁
    final Lock r=rwl.readLock();
   //创建写锁
   final Lock w=rwl.writeLock();
   //读缓存
    V get(K key){
        r.lock();
        try {
            return m.get(key);
        }finally {
            r.unlock();
        }
    }
    //写缓存
    V put(K key, V v){
        w.lock();
        try {
            return m.put(key,v);
        }finally {
            w.unlock();
        }
    }
}