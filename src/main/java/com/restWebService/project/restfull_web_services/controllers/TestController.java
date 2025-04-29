package com.restWebService.project.restfull_web_services.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/test")
    public String testController() {
        return "Hello world!!";
    }

    @GetMapping("/test-bean")
    public TestBean testBean() {
        return new TestBean("Hello world bean !!!");
    }

}
