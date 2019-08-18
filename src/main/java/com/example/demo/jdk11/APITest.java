//package com.example.demo.jdk11;
//
//import org.junit.Test;
//
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Stream;
//
//public class APITest {
//
//
//    /**
//     * JDK 11 增强集合类
//     *
//     */
//    @Test
//    public void test1(){
//        // 创建固定的集合类
//        List<String> uuu = List.of("123", "234", "uuu");
//        System.out.println("uuu = " + uuu);
//
//        Set<Integer> set = Set.of(1, 2, 3, 4, 5);
//        System.out.println("set = " + set);
//        System.out.println("set.getClass = " + set.getClass());
//
//    }
//
//    /**
//     * 流 操作
//     */
//    @Test
//    public void streamTest(){
//        // 不能传入null
//        Stream<Integer> stream = Stream.of(2, 4, 6, 7, 88);
//        stream.forEach(System.out::println);
//
//        // 可以传入null
//        Stream<Integer> stream1 = Stream.ofNullable(null);
//        stream1.forEach(System.out::println);
//
//        // takeWhile : 从流中取出判定为真的元素，一旦遇到假，终止处理
//        // dropWhile ：和上面相反
//        Stream<Integer> integerStream = stream.takeWhile(t -> t % 2 != 0);
//
//        // 迭代，创建流，如下是创建小于1000的并且是2的倍数的数字流
//        Stream<Integer> iterate = Stream.iterate(1, t -> t < 1000, t -> 2 * t);
//
//    }
//
//
//
//
//}
