package com.example.demo.jdk8;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class DateTest {


    /*
    传统的时间处理存在线程安全问题
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        SimpleDateFormat yyyy_mm_dd = new SimpleDateFormat("yyyy MM dd");
        ExecutorService executorService =
                Executors.newFixedThreadPool(10);
        Callable<Date> callable = new Callable<Date>() {

            @Override
            public Date call() throws Exception {
                return yyyy_mm_dd.parse("2019 08 19");
            }
        };

        List<Future<Date>> results = new ArrayList<>();
         for (int i = 0; i < 10; i++) {
             Future<Date> future = executorService.submit(callable);
             results.add(future);
         }

        for (Future<Date> future: results){
            System.out.println("future = " + future.get());
        }


    }

    /*
        新的时间API
        LocalDate 日期
        LocalDateTime 日期时间
        LocalTime 时间

    */
    @Test
    public void test(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        // 加两年
        LocalDateTime localDateTime = now.plusYears(2);
        System.out.println("localDateTime = " + localDateTime);

        int monthValue = now.getMonthValue();
        System.out.println("monthValue = " + monthValue);

    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");
        ExecutorService executorService =
                Executors.newFixedThreadPool(10);
        Callable<LocalDate> callable = new Callable<LocalDate>() {

            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20181019",yyyyMMdd);
            }
        };

        List<Future<LocalDate>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<LocalDate> future = executorService.submit(callable);
            results.add(future);
        }

        for (Future<LocalDate> future: results){
            System.out.println("future = " + future.get());
        }

    }

    /*
    Instant
     */
    @Test
    public void test3() {
        // 默认获取的UTC时区，并不是本地时间
        Instant now = Instant.now();
        System.out.println("now = " + now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime = " + offsetDateTime);

        long l = now.toEpochMilli();    //时间戳
        System.out.println("l = " + l);
    }

    /**
     * Duratuion 计算两个时间的间隔
     * Period: 计算 日期之间的间隔
     */
    @Test
    public void test4() throws InterruptedException {

        Instant now = Instant.now();

        Thread.sleep(100);

        Instant end = Instant.now();

        Duration between = Duration.between(now, end);
        System.out.println("between = " + between.toMillis());
    }
    @Test
    public void test5()
    {
        DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
        String format = LocalDateTime.now().format(isoDate);
        System.out.println("format = " + format);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
    }

    @Test
    public void test6(){
        Set<String> availableZoneIds =
                ZoneId.getAvailableZoneIds();
        System.out.println("availableZoneIds = " + availableZoneIds);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Cuiaba"));
        System.out.println("now = " + now);
    }



}
