package com.restWebService.project.restfull_web_services.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    
    private Integer id;

    @Size(min = 2, message = "Name should have atleast 2 character")
    private String name;

    @Past(message = "Birthdate should be in the past")
    private LocalDate birthDate;
}
