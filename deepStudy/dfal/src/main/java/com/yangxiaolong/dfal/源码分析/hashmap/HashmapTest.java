package com.yangxiaolong.dfal.源码分析.hashmap;

import java.util.HashMap;

public class HashmapTest {

    public static void main(String[] args) {

        HashMap<Object, Object> map = new HashMap<>();
        map.put()
        int num = num(5);
        System.out.println(num);
    }

    public static int num(int i){
        i |= (i>>1);
        i |= (i>>2);
        i |= (i>>4);
        i |= (i>>8);
        i |= (i>>16);
        System.out.println(i);
        int i1 = i - (i >>> 1);
        return i1;
    }
}
