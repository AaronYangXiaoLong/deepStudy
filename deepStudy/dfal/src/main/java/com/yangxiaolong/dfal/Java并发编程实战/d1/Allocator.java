package com.yangxiaolong.dfal.Java并发编程实战.d1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YXL
 * @date 2019/12/12 15:11
 */
public class Allocator {
    private List<Object> als= new ArrayList<>();

    //一次申请到所以的资源
    synchronized boolean apply(Object from,Object to){
        if (als.contains(from)||als.contains(to)){
            return false;
        }else{
            als.add(from);
            als.add(to);
        }
        return true;
    }
    //归还资源
    synchronized void free(Object from,Object to){
        als.remove(from);
        als.remove(to);
    }
}

