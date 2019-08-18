package com.example.demo.mianshi;

public class Zi extends Fu {

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println(" 子类构造代码块 ");
    }

    public Zi() {
        System.out.println("子类构造方法" );
    }

    public static void main(String[] args) {
        System.out.println("开始创建子类对象========");
        new Fu();
    }

}
