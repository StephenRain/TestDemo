package com.example.demo.jdk8;

import com.example.demo.entity.Employee;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    // 可以快速锁定空指针发生的位置
    @Test
    public void test1(){
        Optional<Object> o = Optional.of(null);
    }

    @Test
    public void test2(){
        Optional<Employee> empty = Optional.empty();
        Employee employee = empty.get();
    }

    @Test
    public void test3(){
        Optional<Employee> employee = Optional.ofNullable(null);
        employee.ifPresent(System.out::println);
        employee.orElseGet(Employee::new);
    }





}
