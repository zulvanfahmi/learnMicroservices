package com.restWebService.project.restfull_web_services.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String details;

}
