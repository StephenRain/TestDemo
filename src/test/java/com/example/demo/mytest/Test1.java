package com.example.demo.mytest;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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


}
