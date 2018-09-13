package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.domain.Goal;
import com.thefallenbrain.stayfithub.services.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoalController {

    @Autowired
    private GoalRepository goalRepository;

    @GetMapping("/goals")
    public List<Goal> retrieveAllWorkouts(){
        return goalRepository.findAll();
    }
}
