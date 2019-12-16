package com.yangxiaolong.dfal.Jvm从0成为实战高手.d1;

/**
 * @author YXL
 * @date 2019/12/12 17:27
 */
public class Jvm {

    /**
     *  1.Java代码文件,编译成.class字节码文件-->然后从代码的主类在JVM进程启动后被加载到内存,接着
     *  遇到我要使用的类,就从对应的字节码文件加载对应的类到内存里来.
     *  2.首先是验证.class文件是否符合规范
     *  准备阶段:接着给类及类变量分配内存空间给定一个默认值
     *  解析状态:把符号引用替换为直接引用
     *  初始化阶段:为类的静态变量赋予正确的初始值以及类的静态代码块,如果他的父类还没有初始化,必须先初始
     *  化的父类.
     *  3.类加载器和双亲委派机制
     *  Bootstrap ClassLoader:主要加载我们机器上安装的Java(lib)核心类
     *
     */
}
