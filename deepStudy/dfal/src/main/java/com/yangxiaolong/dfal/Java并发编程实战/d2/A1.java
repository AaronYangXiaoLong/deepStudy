package com.yangxiaolong.dfal.Java并发编程实战.d2;

import java.util.List;

/**
 * @author YXL
 * @date 2019/12/16 9:29
 */
public class A1 {
    /**
     * 等待唤醒机制
     * 1.如果说条件不满足,线程阻塞自己,进入等待状态,释放CPU的占有权,如果条件满足,则通知阻塞等待线程重新执行
     * 解决等待消耗CPU问题
     * wait方法是Object类的,sleep是Thread类的.使用wait方法释放锁线程首先获取互斥锁,当线程不满足时,释放互斥锁,进入等待状态,当条件满足时,通知等待的线程,重新获取互斥锁.
     * 等待唤醒机制:线程首先获取互斥锁,当线程不满足时,释放互斥锁,进入等待状态,当条件满足时,通知等待的线程,重新获取互斥锁.
     *
     */
}

class Allocator {
    private List<Object> als;

    //一次性申请所以的资源
    synchronized void apply(Object from, Object to) {
        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (Exception e) {

            }
            als.add(from);
            als.add(to);
        }
    }

    //归还资源
    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }
}
