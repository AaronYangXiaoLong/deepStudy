package com.yangxiaolong.dfal.Java并发编程实战.d2;

/**
 * @author YXL
 * @date 2019/12/16 9:58
 */
public class Test {
    public static void main(String[] args) {
        int num=1;
        int num1=2;
        System.out.println(test(num,num1));;
    }

    private static Boolean test(int num, int num1) {
        if (num>3||num1>5){
            return true;
        }
        return false;
    }
}
