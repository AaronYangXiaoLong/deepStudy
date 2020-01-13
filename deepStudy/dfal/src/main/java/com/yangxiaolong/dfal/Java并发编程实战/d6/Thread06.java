package com.yangxiaolong.dfal.Java并发编程实战.d6;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;

public class Thread06 {
    AtomicLong count = new AtomicLong(0);
    void add10k() {
        int idx = 0;
        while (idx++ < 10000) {
            count.getAndIncrement();
        }
    }
}

//CAS实现原理
class SimulatedCAS {
    int count;

    synchronized int cas(int expect, int newValue) {
        //读取目前count值
        int curValue = count;
        if (curValue == expect) {
            count = newValue;
        }
        return curValue;
    }

}

//一般池子资源
class xxxpool {
    //获取池化资源
    void xxxAcquire() {
    }

    void xxxrelease() {
    }
}

//线程池一般采用生产者和消费者来设计
class myThreadPool {
    //利用阻塞队列实现生产者 - 消费者
    BlockingQueue<Runnable> workQueue;
    //保存内部工作线程
    List<WorkerThread> threads = new ArrayList<WorkerThread>();


}

class WorkerThread extends Thread {
    BlockingQueue<Runnable> workQueue;
    @Override
    public void run() {

        while (true) {
            Runnable tast = null;
            try {
                tast = workQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tast.run();
        }
    }
}


