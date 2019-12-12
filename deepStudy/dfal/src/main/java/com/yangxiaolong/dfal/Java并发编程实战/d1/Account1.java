package com.yangxiaolong.dfal.Java并发编程实战.d1;

/**
 * @author YXL
 * @date 2019/12/12 10:57
 * 模拟转账业务,假如存在转出和转入账户,转出账本和转入账本
 * 只有当转出账本和转入账本都存在的时候,才会执行转账业务.
 */
public class Account1 {
    private Allocator actr;
    private int balance;

    void transfer(Account1 target, int amt) {
        //一次性申请转出账户和转入账户
        while (actr.apply(this, target)) {
            try {
                //锁定转出账户
                synchronized (this) {
                    //锁定转入账户
                    synchronized (target) {
                        if (this.balance > amt) {
                            this.balance -= amt;
                            target.balance += amt;
                        }
                    }
                }

            } finally {
                actr.free(this, target);
                System.out.println("测试修改");
            }
        }
        /**
         * 产生死锁的原因:
         * 可以理解共享资源就是锁.
         * 1.互斥,共享资源X和Y只能被一个线程占用
         * 2.占用且等待,线程T1已经取得共享资源X,在等待共享资源Y时,不释放共享资源
         * 3.不可抢占:其他线程不能强行占线程T1占用的线程
         * 4.循环等待,线程T1线程T2占用的资源,线程T2等待线程T1占用的资源,就是循环等待
         */
        //解决方式
        /**
         * 1.破坏占用且等待(成本最低的方式了)
         * 给临界区增加一个管理员,可以同时申请到当前资源和释放当前资源
         * 2.破坏不可抢占条件:这里采用java.util.concurrent包下的Lock.
         * 3.破坏循环等待条件
         * 假设每个用户都有不同的属性Id作为排序字段,申请时按照从小到大的顺序来申请.
         */
    }
}
