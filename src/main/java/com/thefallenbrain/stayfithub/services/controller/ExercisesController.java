package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.domain.Exercise;
import com.thefallenbrain.stayfithub.services.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@BasePathAwareController
public class ExercisesController {

    @Autowired
    ExerciseRepository exerciseRepository;

    @PutMapping(value = "exercises/{id}")
    @ResponseBody
    void update(@PathVariable Integer id, @RequestBody Exercise exercise){
        exercise.setId(id);
        exerciseRepository.save(exercise);
    }
}
