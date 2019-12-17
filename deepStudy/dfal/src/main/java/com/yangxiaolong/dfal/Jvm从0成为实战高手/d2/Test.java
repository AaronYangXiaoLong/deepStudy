package com.yangxiaolong.dfal.Jvm从0成为实战高手.d2;

/**
 * @author YXL
 * @date 2019/12/16 17:13
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Child.str);
        System.out.println("=============");
    }
}

class Parent {
    static String str = "hello world Parent";

    static {
        System.out.println("parent load");
    }
}

 class Child extends Parent {
  final static  int str = 2;

    static {
        System.out.println("Child load");
    }
}