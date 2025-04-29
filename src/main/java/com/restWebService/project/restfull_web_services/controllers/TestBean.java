package com.restWebService.project.restfull_web_services.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestBean {

    private String message;

    public TestBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Hello world test bean " + message ;
    }

}
