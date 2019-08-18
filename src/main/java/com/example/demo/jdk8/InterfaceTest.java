package com.example.demo.jdk8;

public interface InterfaceTest {


    default String getName(){
        return "haha ";
    }

    public static String getValue(){
        return "hehe ";
    }
}
