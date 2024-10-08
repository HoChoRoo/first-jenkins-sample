package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String sayHello() {
        System.out.println("hello!!");
        return "Hello, World!";
    }
}