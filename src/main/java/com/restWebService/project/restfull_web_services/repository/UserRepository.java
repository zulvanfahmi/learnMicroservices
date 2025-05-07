package com.restWebService.project.restfull_web_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restWebService.project.restfull_web_services.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    
     
}
