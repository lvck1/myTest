package com.lvck1.study;

public class Son extends Father {
    static {
        System.out.println("子类静态代码块");
    }

    Son() {
        System.out.println("子类构造方法");
    }

    {
        System.out.println("子类实例化块");
    }

    public void run() {
        System.out.println("子类实例方法");
    }

    public static void main(String[] args) {
        Son son = new Son();
    }
}
