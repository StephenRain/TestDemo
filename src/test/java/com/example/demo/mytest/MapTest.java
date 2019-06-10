package com.example.demo.mytest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    /*
    面试题：
        1、初始容量为20的hashMap的容量为多少？
            答：应该就是32。
     */
    @Test
    public void testHashMap() {
        System.out.println("测试开始！");
        // 经过测试
        Map<String,String> map = new HashMap<>(16);
        map.put("1","v1");
    }

}
