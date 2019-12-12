package com.yangxiaolong.dfal.Java并发编程实战.d1;

/**
 * @author YXL
 * @date 2019/12/12 10:05
 */
public class Account {
    //锁,保护账户余额
    private final Object balLock=new Object();
    //账户余额
    private Integer balance;
    //锁,保护账户密码
    private final Object pwLock=new Object();
    //账户密码
    private String password;
    //取款
    void withdraw(Integer amt){
        synchronized (balLock){
            if (this.balance>amt){
                this.balance-=amt;
            }
        }
    }
    //查看余额
    Integer getBalance(){
        synchronized (balLock){
            return balance;
        }
    }
    //更改密码
    void updatePassword(String pw){
        synchronized (pwLock){
            this.password=pw;
        }
    }
    //查看密码
    String getPassword(){
        synchronized (pwLock){
            return password;
        }
    }
    /*转账
    *临界区:transfer(),受保护的资源:this.balance target.balance,
    * 如果A-->B 100元,B-->C 100元 线程一 线程二 可能同时读到B.balance=200元.
    * 那么会出现B最后的账号可能是300元或者100元,就是不可能是200元.
    * 我想用一个锁锁住多个资源,那么这个锁的对象必须具有唯一性.
    * */
    synchronized void transfer(Account target,int amt){
        if (this.balance>amt){
            this.balance-=amt;
            target.balance+=amt;
        }
    }
}