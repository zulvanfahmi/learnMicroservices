package com.restWebService.project.restfull_web_services.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restWebService.project.restfull_web_services.posts.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "user_details")
public class User {
    
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "Name should have atleast 2 character")
    @JsonProperty("user_name")
    private String name;

    @Past(message = "Birthdate should be in the past")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    // @JsonIgnore
    private List<Post> posts;
}
