package com.restWebService.project.restfull_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering() {
        return new SomeBean("Value 1", "Value 2", "Value 3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList() {
        return Arrays.asList(
            new SomeBean("Value 1", "Value 2", "Value 3"),
            new SomeBean("Value 1", "Value 2", "Value 3")
        );
    }

}