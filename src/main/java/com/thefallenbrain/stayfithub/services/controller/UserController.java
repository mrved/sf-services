package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.controller.security.User;
import com.thefallenbrain.stayfithub.services.domain.EndUser;
import com.thefallenbrain.stayfithub.services.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<EndUser> retrieveUsers() {
        return userRepository.findAll();
    }
}

