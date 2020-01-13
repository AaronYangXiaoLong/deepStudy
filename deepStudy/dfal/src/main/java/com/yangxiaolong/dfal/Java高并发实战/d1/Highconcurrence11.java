package com.yangxiaolong.dfal.Java高并发实战.d1;

public class Highconcurrence11 {

    private final double salary;

    private final double bonus;

    private CalculatorStrategy calculatorStrategy;

    public Highconcurrence11(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }
    //内部方法决定算法
    protected double caleTax(){
        return calculatorStrategy.calculate(salary,bonus);
    }
    //调用固定的计算方法
    public double calculate(){
        return this.caleTax();
    }
}

/**
 *实现策略模式
 * 1.定义接口
 * 2.实现类实现接口,定义算法
 * 3.保护方法调用实现类
 * 4.实例调用固定方法-->调用内部保护方法
 */
interface CalculatorStrategy{
    public double calculate(double salary,double bonus);
}

class CalculatorStrategyImpl implements CalculatorStrategy{
    private final static double SALARY_RATTE=0.1;
    private final static double BONUS_RATTE=0.15;
    @Override
    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATTE+bonus*BONUS_RATTE;
    }
}

