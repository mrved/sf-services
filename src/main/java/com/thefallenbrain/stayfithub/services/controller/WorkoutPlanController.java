package com.thefallenbrain.stayfithub.services.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import java.util.List;
import com.thefallenbrain.stayfithub.services.domain.Exercise;
import com.thefallenbrain.stayfithub.services.domain.Member;
import com.thefallenbrain.stayfithub.services.domain.WorkoutExercise;
import com.thefallenbrain.stayfithub.services.domain.WorkoutPlan;
import com.thefallenbrain.stayfithub.services.repository.MemberRepository;
import com.thefallenbrain.stayfithub.services.repository.WorkoutExerciseRepository;
import com.thefallenbrain.stayfithub.services.repository.WorkoutPlanRepository;
import org.bouncycastle.cert.ocsp.Req;
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
import java.util.ArrayList;
import java.util.Date;
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
    void setWorkoutPlan(@PathVariable Integer id,
                        @RequestParam(name = "workoutPlanId") Integer workoutPlanId,
                        @RequestParam(name = "startDate")Date startDate,
                        @RequestParam(name = "endDate") Date endDate){
        Member member = memberRepository.findById(id).get();
        member.setWorkoutPlanStartDate(startDate);
        member.setWorkoutPlanEndDate(endDate);
        WorkoutPlan workoutPlan = workoutPlanRepository.findById(workoutPlanId).get();
        member.setWorkoutPlan(workoutPlan);
        memberRepository.save(member);
    }

    @GetMapping(value = "members/{id}/todaysWorkoutPlan")
    @ResponseBody
    List<WorkoutExercise> getTodaysWorkoutPlan(@PathVariable Integer id){
        Date date = new Date();
        date.getDay();
        WorkoutPlan workoutPlan = memberRepository.findById(id).get().getWorkoutPlan();
        List<WorkoutExercise> workoutExercises = new ArrayList<>();
        for(WorkoutExercise workoutExercise : workoutPlan.getWorkoutExercises()){
            if(toIntDay(workoutExercise.getDayOfWeek()) == date.getDay()){
               workoutExercises.add(workoutExercise);
            }
        }
        return workoutExercises;
    }

    private int toIntDay(String dayOfWeek) {
        String[] daysOfWeek = {"sunday", "monday", "tuesday", "wednesday", "thursday",
        "friday", "saturday"};
        int count = 0;
        for(String weekDay: daysOfWeek){
            if(weekDay.equalsIgnoreCase(dayOfWeek) || weekDay.startsWith(dayOfWeek.toLowerCase()))
                return count;
            ++count;
        }
        return  -1;
    }
}
