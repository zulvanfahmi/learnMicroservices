package com.restWebService.project.restfull_web_services.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Hello world test bean " + message ;
    }

}
