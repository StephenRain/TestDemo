package com.example.demo.jdk8;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestAnnotation {


    @Test
    public void test1() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method show = clazz.getMethod("show");
        MyAnnotation[] annotations = show.getAnnotationsByType(MyAnnotation.class);
        Arrays.stream(annotations).map(MyAnnotation::value).forEach(System.out::println);




    }



    @MyAnnotation("hello")
    public void show(@MyAnnotation("hello") String string){

    }


}
