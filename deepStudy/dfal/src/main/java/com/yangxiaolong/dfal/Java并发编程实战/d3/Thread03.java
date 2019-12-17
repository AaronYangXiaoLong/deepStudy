package com.yangxiaolong.dfal.Java并发编程实战.d3;

/**
 * @author YXL
 * @date 2019/12/17 13:29
 */
public class Thread03 {
    /**
     * 创建多少线程才合适?
     * cpu的计算以及IO操作
     * 1.假如只有一个线程,在进行cpu计算时,Io空闲-->利用率只有50%
     * 对应4核cpu来说,一个线程,cpu的利用率只有25%,而4个线程则利用率100%
     * 对于cpu密集型计算,多线程的实质是提升多核cpu的利用率,所以避免线程的切换,理论来说创建对应的cpu数就行了
     * 线程的数量 =CPU 核数
     *
     * 2.对于I/O密集型的计算场景,考虑cpu和I/O的时间,最佳线程数=cpu*[1+(I/O耗时 / CPU耗时)]
     * 注:测试IO/CPU的工具:apm
     *
     * 3.并发编程和面向对象 封装共享变量 识别共享变量的约束条件 指定并发访问策略
     * 面向对象思想:封装 将属性和实现细节封装在对象内部,外界对象只能通过目标对象提供的方法去访问这些属性
     * 并发编程思路: 将共享变量作为对象属性封装在内部,对所以公共方法制定并发策略.
     * 对于不会发生变化的共享变量,使用final关键字修饰就好
     *
     */
}
class Counter{
    private long value;
    synchronized long get(){
        return value;
    }
    synchronized long addOne(){
        return ++value;
    }

}
class ThreadTest03{
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Counter counter = new Counter();

        new Thread("测试线程"){
            @Override
            public void run(){
                for (int i = 0; i < 50; i++) {
                    counter.addOne();
                    System.out.println(counter.get()+"测试线程");
                }
            }
        }.start();

        for (int i = 0; i <60; i++) {
            counter.addOne();
            System.out.println(counter.get()+"主线程");
            Thread.sleep(1);
        }

        System.out.println("主线程结束");
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "毫秒");
    }

}
