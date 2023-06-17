package com.lvck1.study;

public class Father {

    static {
        System.out.println("父类静态代码块");
    }

    Father() {
        System.out.println("父类构造方法");
    }

    {
        System.out.println("父类实例化块");
    }

    public void run() {

    }
}
