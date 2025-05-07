package com.restWebService.project.restfull_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

// import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
// @JsonIgnoreProperties("field1")
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String field1;

    // @JsonIgnore
    private String field2;
    private String field3;

}
