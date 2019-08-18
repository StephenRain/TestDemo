package com.example.demo.simple;

import org.junit.Test;

public class integerTest {

    @Test
    public void testInt () {

        Integer a = 128;
        Integer b = 128;
        System.out.println("(a==b) = " + (a == b));
        System.out.println("(a==b) = " + (a.equals(b)));

    }
}
