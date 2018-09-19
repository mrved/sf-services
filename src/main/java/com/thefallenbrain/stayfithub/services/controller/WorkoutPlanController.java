package com.thefallenbrain.stayfithub.services.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.thefallenbrain.stayfithub.services.domain.Exercise;
import com.thefallenbrain.stayfithub.services.domain.Member;
import com.thefallenbrain.stayfithub.services.domain.WorkoutExercise;
import com.thefallenbrain.stayfithub.services.domain.WorkoutPlan;
import com.thefallenbrain.stayfithub.services.repository.MemberRepository;
import com.thefallenbrain.stayfithub.services.repository.WorkoutExerciseRepository;
import com.thefallenbrain.stayfithub.services.repository.WorkoutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@BasePathAwareController
public class WorkoutPlanController {
    @Autowired
    WorkoutPlanRepository workoutPlanRepository;

    @Autowired
    WorkoutExerciseRepository workoutExerciseRepository;

    @Autowired
    MemberRepository memberRepository;

    @PutMapping(value = "workoutPlans/{id}")
    @ResponseBody
    void updateWorkoutPlan(@PathVariable Integer id, @RequestBody WorkoutPlan workoutPlan){
        for(WorkoutExercise w : workoutPlan.getWorkoutExercises()){
            workoutExerciseRepository.save(w);
        }
        workoutPlan.setId(id);
        System.out.println(workoutPlan.getMuscleGroups());
        workoutPlanRepository.save(workoutPlan);
    }

    @PostMapping(value = "workoutPlans")
    @ResponseBody
    void updateWorkoutPlan(@RequestBody WorkoutPlan workoutPlan){
        for(WorkoutExercise w : workoutPlan.getWorkoutExercises()){
            workoutExerciseRepository.save(w);
        }
        System.out.println(workoutPlan.getMuscleGroups());
        workoutPlanRepository.save(workoutPlan);
    }

    @PutMapping(value = "members/{id}/workoutPlans")
    @ResponseBody
    void setWorkoutPlan(@PathVariable Integer id, @RequestBody WorkoutPlan workoutPlan){
        Member member = memberRepository.findById(id).get();
        member.setWorkoutPlan(workoutPlan);
        memberRepository.save(member);
    }
}
