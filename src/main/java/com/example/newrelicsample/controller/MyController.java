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

}
