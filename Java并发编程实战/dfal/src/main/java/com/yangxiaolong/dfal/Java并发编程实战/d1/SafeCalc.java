package com.yangxiaolong.dfal.Java并发编程实战.d1;

/**
 * @author YXL
 * @date 2019/12/12 9:14
 */
public class SafeCalc {
    static long value=0L;
/*
    同一个共享的资源,但是由两把锁锁住,由于两个临界区没有互斥关系,存在并发问题.
    可以得出的结论是:如果说一个线程value+1,但是不具有可见性.
    保护资源和锁之间合理的关联关系应该是N:1,也就是一把锁保护多个资源.

*/
    synchronized long get(){
        return value;
    }
    //static修饰的方法锁的对象是类.class
    synchronized static void addOne(){
        value+=1;
    }

}
