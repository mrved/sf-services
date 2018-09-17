package com.thefallenbrain.stayfithub.services.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.thefallenbrain.stayfithub.services.domain.Exercise;
import com.thefallenbrain.stayfithub.services.domain.WorkoutPlan;
import com.thefallenbrain.stayfithub.services.repository.WorkoutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@BasePathAwareController
public class WorkoutPlanController {
    @Autowired
    WorkoutPlanRepository workoutPlanRepository;

    @PutMapping(value = "workoutPlans/{id}")
    @ResponseBody
    void updateWorkoutPlan(@PathVariable Integer id, @RequestBody WorkoutPlan workoutPlan){
//        Optional<WorkoutPlan> exercise1 = workoutPlanRepository.findById(id);
//        if(exercise1.isPresent()){
//            workoutPlanRepository.deleteById(id);
//        }
        workoutPlan.setId(id);
        workoutPlanRepository.save(workoutPlan);
   }
}
