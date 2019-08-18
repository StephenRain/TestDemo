package com.example.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Employee {


    private String name;

    private String idCard;

    private int age;
}
