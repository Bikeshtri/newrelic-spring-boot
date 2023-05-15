package com.example.newrelicsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    String myHome() {
        System.out.println("request received...");
        return "Hello World!";
    }

    @GetMapping("/error-path")
    String myeHome() {
        System.out.println(10/0);
        return "Hello World!";
    }

    @GetMapping("/delay")
    String mydHome() throws InterruptedException {
        Thread.sleep(10000);
        return "Hello World!";
    }

}
