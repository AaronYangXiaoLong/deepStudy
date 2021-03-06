package com.yangxiaolong.dfal.Java并发编程实战.d2;

/**
 * @author YXL
 * @date 2019/12/16 12:57
 */
public class Account {
    /**
     * 1.并发问题:安全性,活跃性,性能问题
     * 当多个线程同时读写同一数据时,就得考虑线程是否安全:原子性,可见性,有序性
     * 竞争条件:程序的执行结果依赖于线程执行的顺序,在并发环境里,线程的执行顺序是不确定的.
     * 2.活跃性锁的问题
     * 死锁:线程相互等待,线程永久性阻塞.
     * 活锁:线程没有阻塞,但无法执行下去.-->等待随机的时间切换解决.
     * 饥饿:线程无法访问所需资源而无法进行下去的情况.-->公平分配资源(公平锁:先来后到原则,线程等待是有顺序的),避免锁的线程长时间执行.
     * 3.性能问题:
     * 临界区的资源是串行化的,减少串行
     * 吞吐量:单位时间能够处理的请求数量,吞吐越高,性能越好.
     * 延迟:发出请求到收到请求的时间,延迟越小越好
     * 并发量:同时处理的请求数量-->
     *
     */
}
