package com.restWebService.project.restfull_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    
    // JPA / Hibernate > Database
    // UserDaoService > Static List

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Sumanto", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Sumanti", LocalDate.now().minusYears(35)));
        users.add(new User(3, "Sumantul", LocalDate.now().minusYears(50)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

}
