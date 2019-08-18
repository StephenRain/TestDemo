//package com.example.demo.jdk11;
//
//import org.junit.Test;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//
//public class HttpClientTest {
//
//
//    /**
//     *  GET 方法
//     * @throws IOException
//     * @throws InterruptedException
//     */
//    @Test
//    public void test1 () throws IOException, InterruptedException {
//
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://www.baidu.com")).build();
//        HttpResponse.BodyHandler<String> stringBodyHandler = HttpResponse.BodyHandlers.ofString();
//        HttpResponse<String> response = httpClient.send(httpRequest, stringBodyHandler);
//        String body = response.body();
//        System.out.println("body = " + body);
//
//
//    }
//
//
//}
