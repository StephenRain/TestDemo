package com.example.demo.mianshi;

public class Fu {


    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println(" 父类构造代码块 ");
    }

    public Fu() {
        System.out.println("父类构造方法 ");
    }
}
