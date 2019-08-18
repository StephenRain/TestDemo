package com.example.demo.mytest;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;

public class Test1 {


    /*
    函数式编程测试
     */
    @Test
    public void test001() {
        int[] arr = {2, 33, 66, 999};
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println(" =====================");
        Arrays.stream(arr).map((x) -> x = x + 1).forEach(System.out::println);

        // 声明函数
        Function<Integer, Integer> stringCon = (from) -> from * 10;
        Integer apply = stringCon.apply(3);
        System.out.println("apply = " + apply);

    }

    @Test
    public void test002() {
        int e = 200;

        Integer a = new Integer(200);
        Integer b = new Integer(200);
        Integer c = 200;
        Integer f = 200;
        int d = 200;

        System.out.println("a == e" + (a == e));
        System.out.println("a == c" + (a == c));
        System.out.println("b == c" + (b == c));
        System.out.println("a == d" + (a == d));
        System.out.println("c == d" + (c == d));
        System.out.println("f == d" + (f == d));



    }

}
