package com.thefallenbrain.stayfithub.services.bootstrap;

import com.thefallenbrain.stayfithub.services.controller.security.Authority;
import com.thefallenbrain.stayfithub.services.controller.security.Role;
import com.thefallenbrain.stayfithub.services.domain.*;
import com.thefallenbrain.stayfithub.services.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class StayFitBootstrap implements ApplicationListener<ContextRefreshedEvent>{


    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private EndUserRepository userRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private FitnessCenterRepository fitnessCenterRepository;

    @Autowired
    private FrontdeskAdminRepository frontdeskAdminRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        Role generalRole = new Role();
        generalRole.setRole("GENERAL");

        Authority readAuthority = new Authority();
        readAuthority.setName("READ");

        authorityRepository.save(readAuthority);

        Authority readWriteAuthority = new Authority();
        readWriteAuthority.setName("READ_WRITE");
        authorityRepository.save(readWriteAuthority);

        List<Authority> authorities = new ArrayList<>();
        authorities.add(readAuthority);
        generalRole.setAuthorities(authorities);

        List<Authority> authorities2 = new ArrayList<>();
        authorities2.add(readWriteAuthority);
        adminRole.setAuthorities(authorities2);

        roleRepository.save(adminRole);
        roleRepository.save(generalRole);
        Goal weightLoss = new Goal();
        weightLoss.setName("Be Healthier");
        weightLoss.setDescription("Eat and train for optimum health");

        Goal weightGain = new Goal();
        weightGain.setName("Loose Weight");
        weightGain.setDescription("Get leaner and increase stamina");

        Goal maintenance = new Goal();
        maintenance.setName("Gain Weight");
        maintenance.setDescription("Build muscle strength");

        goalRepository.save(weightGain);
        goalRepository.save(weightLoss);
        goalRepository.save(maintenance);

        FitnessCenter frazerTown = new FitnessCenter();
        frazerTown.setName("Frazer Town");
        frazerTown.setAddress("243, Frazer Town, Outer Ring Road.");
        frazerTown.setLocation("Bangalore");
        fitnessCenterRepository.save(frazerTown);

        FitnessCenter indranagar = new FitnessCenter();
        indranagar.setName("Indranagar");
        indranagar.setAddress("100 Feet Road, Indranaga");
        indranagar.setLocation("Bangalore");
        fitnessCenterRepository.save(indranagar);

        HeadTrainer guru = new HeadTrainer();
        guru.setName("Guru");
        guru.setDob(new Date());
        guru.setFitnessCenter(frazerTown);
        guru.setRole(generalRole);
        guru.setPassword("$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe");
        guru.setEmail("guru@example.com");
        guru.setGender("Male");
        userRepository.save(guru);

        Trainer alan = new Trainer();
        alan.setName("Alan");
        alan.setDob(new Date());
        alan.setDoj(new Date());
        alan.setFitnessCenter(frazerTown);
        alan.setHeadTrainer(guru);
        alan.setRole(generalRole);
        alan.setPassword("$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe");
        alan.setEmail("alan@example.com");
        alan.setGender("Male");
        userRepository.save(alan);

        Trainer rahul = new Trainer();
        rahul.setName("Rahul");
        rahul.setDob(new Date());
        rahul.setDoj(new Date());
        rahul.setFitnessCenter(frazerTown);
        rahul.setHeadTrainer(guru);
        rahul.setRole(generalRole);
        rahul.setPassword("$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe");
        rahul.setEmail("rahul@example.com");
        rahul.setGender("Male");
        userRepository.save(rahul);

        Member arjun = new Member();
        arjun.setName("Arjun");
        arjun.setDob(new Date());
        arjun.setGoal(weightGain);
        arjun.setFitnessCenter(frazerTown);
        arjun.setTrainer(alan);
        arjun.setHeadTrainer(guru);
        arjun.setFitnessCenter(frazerTown);
        arjun.setRole(generalRole);
        arjun.setPassword("$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe");
        arjun.setEmail("arjun@example.com");
        arjun.setGender("Male");


        Member ved = new Member();
        ved.setName("Ved");
        ved.setUsername("mrvedsachdeva@gmail.com");
        ved.setEmail("mrvedsachdeva@gmail.com");
        ved.setPassword("$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe");
        ved.setDob(new Date());
        ved.setGoal(weightLoss);
        ved.setFitnessCenter(frazerTown);
        ved.setTrainer(alan);
        ved.setHeadTrainer(guru);
        ved.setFitnessCenter(frazerTown);
        ved.setRole(generalRole);
        ved.setEnabled(true);
        ved.setGender("Male");
        userRepository.save(ved);
        userRepository.save(arjun);

        Exercise exercise = new Exercise();
        exercise.setName("Biceps Curl");
        exercise.setCaloriesBurn(22);

        exerciseRepository.save(exercise);

        Workout workout = new Workout();
        workout.setHeadTrainer(guru);
        workout.setMember(arjun);
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.add(exercise);
        workout.setExercises(exerciseList);
        workoutRepository.save(workout);

        FrontdeskAdmin frontdeskAdmin = new FrontdeskAdmin();
        frontdeskAdmin.setFitnessCenter(frazerTown);
        frontdeskAdmin.setName("Madar Fuchaa");
        frontdeskAdmin.setRole(generalRole);
        frontdeskAdmin.setPassword("$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe");
        frontdeskAdmin.setEmail("frontdeskAdmin@example.com");
        frontdeskAdmin.setGender("Male");

        frontdeskAdminRepository.save(frontdeskAdmin);

    }
}
