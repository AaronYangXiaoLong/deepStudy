package com.yangxiaolong.dfal.redis.d1;

public class Redis01 {
    /**
     * 1.redis线程模型
     * 核心:文件事件处理器-采用IO多路复用机制监听队列
     * 客户端发起一次请求,服务端是有server socket监听请求的,产生事件AE_READABLE
     * IO多路复用程序监听socket-->压入到队列中-->文件事件分派器 多个事件处理器 :
     * 连接应答处理器(第一次初始化的时候,redis会将连接应答处理器跟AE_READABLE连接起来
     * -->同时跟命令请求处理器关联起来,客户端发起一次连接,会产生AE_READABLE事件,)
     * ,命令请求处理器(处理客户端发过来的请求,处理完毕后关联)命令回复处理器,当客户端准备好
     * 读取响应数据时,就会在socket产生一个AE_WRITABLE事件,会由对应的命令回复处理器来处理,
     * 将准备好的数据写入socket,供客户端读取-->写完后删除这个socket的AE_WRITABLE事件和命令回复处理器的关联
     *
     * 2.redis为什么这么快
     * 非阻塞的IO多路复用程序
     * 纯内存的操作,内存速度快,一秒可以处理几万请求,处理高并发
     *
     * 3.String 简单的K V
     * Hash 类似于Map key 对象
     * list :可以重复数据,粉丝,评论列表
     * set :无序不能重复的
     * zset:可以带分数,自动排行
     *
     * 4.redis的删除策略
     * 定期删除+惰性删除
     * 定期删除:随机抽取设置了过期时间的key,过期就删除-->问题在于很多的key到了时间但是也没有删除
     * 惰性删除:在获取某个key的时候,redis会检查一下,如果设置了过期时间,就会删除
     *
     * 5.如果说redis内存满了怎么办(内存淘汰机制)
     * noevication:内存不足,报错
     * allkeys-lru:内存不足,在key空间移除最少使用的key
     * allkeys-random:内存不足,随机删除key
     * volatile-lru:在设置了过期时间的key空间中移除最少使用的.
     * volatile-random:
     * volatile-ttl:
     */
}
