package com.thefallenbrain.stayfithub.services.bootstrap;

import com.mmnaseri.utils.spring.data.dsl.factory.RepositoryFactoryBuilder;
import com.thefallenbrain.stayfithub.services.controller.security.Authority;
import com.thefallenbrain.stayfithub.services.controller.security.Role;
import com.thefallenbrain.stayfithub.services.domain.*;
import com.thefallenbrain.stayfithub.services.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StayFitBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private MembershipTypeRepository membershipTypeRepository;

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

    @Autowired
    MembershipOptionRepository membershipOptionRepository;

    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    MuscleGroupRepository muscleGroupRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    WorkoutPlanRepository workoutPlanRepository;


    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    ThemeRepository themeRepository;


    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    WorkoutExerciseRepository workoutExerciseRepository;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        MembershipOption gym = new MembershipOption("gym", 2500, 6000, 10000, 15000, 9999);
        MembershipOption groupx = new MembershipOption("groupx", 3000, 12000, 12000, 17500, 12500);
        MembershipOption combo = new MembershipOption("combo", 4000, 15000, 15000, 20000, 15000);
        membershipOptionRepository.save(gym);
        membershipOptionRepository.save(groupx);
        membershipOptionRepository.save(combo);



        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        Role generalRole = new Role();
        generalRole.setName("GENERAL");

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
        guru.setDesignation("HeadTrainer");
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
        alan.setDesignation("Trainer");
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
        rahul.setDesignation("Trainer");
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
        Membership membership = new Membership();
        membership.setStartDate(new Date(-10));
        membership.setEndDate(new Date(10));
//        membership.setMembershipType(gym);
        membershipRepository.save(membership);
        arjun.setMembership(membership);
        arjun.setDesignation("Member");


        Member test2 = new Member();
        test2.setName("Ved");
        test2.setUsername("test2@gmail.com");
        test2.setEmail("test2@gmail.com");
        test2.setPassword("$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe");
        test2.setDob(new Date());
        test2.setGoal(weightLoss);
        test2.setFitnessCenter(frazerTown);
        test2.setTrainer(alan);
        test2.setHeadTrainer(guru);
        test2.setFitnessCenter(frazerTown);
        test2.setRole(generalRole);
        test2.setEnabled(true);
        test2.setGender("Male");
        test2.setMembership(membership);
        test2.setDesignation("Member");
        userRepository.save(test2);
        userRepository.save(arjun);



        Workout workout = new Workout();
        workout.setHeadTrainer(guru);
        workout.setMember(arjun);
        workoutRepository.save(workout);

        FrontdeskAdmin frontdeskAdmin = new FrontdeskAdmin();
        frontdeskAdmin.setFitnessCenter(frazerTown);
        frontdeskAdmin.setName("Madar Fuchaa");
        frontdeskAdmin.setRole(generalRole);
        frontdeskAdmin.setPassword("$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe");
        frontdeskAdmin.setEmail("frontdeskAdmin@example.com");
        frontdeskAdmin.setGender("Male");
        frontdeskAdmin.setDesignation("FrontDeskAdmin");

        frontdeskAdminRepository.save(frontdeskAdmin);

        Member ved = new Member();
        ved.setName("Ved");
        ved.setUsername("arjunw7@gmail.com");
        ved.setEmail("arjunw7@gmail.com");
        ved.setPassword("13bcb0062");
        ved.setDob(new Date());
        ved.setGoal(weightLoss);
        ved.setFitnessCenter(frazerTown);
        ved.setTrainer(alan);
        ved.setHeadTrainer(guru);
        ved.setFitnessCenter(frazerTown);
        ved.setRole(generalRole);
        ved.setEnabled(true);
        ved.setGender("Male");
        ved.setMembership(membership);
        ved.setDesignation("Member");

        MembershipType membershipType = new MembershipType();
        membershipType.setDescription("Gym");
        membershipType.setPrice(2500);
        membershipType.setDuration(30L);
        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("GroupX");
        membershipType.setPrice(3000);
        membershipType.setDuration(30L);
        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("Combo");
        membershipType.setPrice(40000);
        membershipType.setDuration(30L);
        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("Gym");
        membershipType.setPrice(6000);
        membershipType.setDuration(90L);
        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("GroupX");
        membershipType.setPrice(9000);
        membershipType.setDuration(90L);
        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("Combo");
        membershipType.setPrice(10000);
        membershipType.setDuration(90L);
        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("Gym");
        membershipType.setPrice(10000);
        membershipType.setDuration(180L);
        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("GroupX");
        membershipType.setPrice(12000);
        membershipType.setDuration(180L);
        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("Combo");
        membershipType.setPrice(15000);
        membershipType.setDuration(180L);
        membershipTypeRepository.save(membershipType);

        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("Gym");
        membershipType.setPrice(15000);
        membershipType.setDuration(365L);
        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("GroupX");
        membershipType.setPrice(17500);
        membershipType.setDuration(365L);
        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("Combo");
        membershipType.setPrice(20000);
        membershipType.setDuration(365L);
        membershipTypeRepository.save(membershipType);

        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("Prelaunch Offer");
        membershipType.setPrice(9999);
        membershipType.setDuration(365L);
        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("Prelaunch Offer");
        membershipType.setPrice(12500);
        membershipType.setDuration(365L);
        membership.setMembershipType(membershipType);
        membershipTypeRepository.save(membershipType);
        membershipType = new MembershipType();
        membershipType.setDescription("Prelaunch Offer");
        membershipType.setPrice(15000);
        membershipType.setDuration(365L);
        membershipTypeRepository.save(membershipType);
        membership.setMembershipType(membershipType);
        membershipRepository.save(membership);
        ved.setMembership(membership);
        userRepository.save(ved);


        // suitable for

        Person men = new Person();
        men.setName("Men");

        Person women = new Person();
        women.setName("Women");

        Person others = new Person();
        others.setName("Others");
        personRepository.save(men);
        personRepository.save(women);
        personRepository.save(others);
        // muscle group

        MuscleGroup legs = new MuscleGroup();
        legs.setName("legs");


        MuscleGroup arms = new MuscleGroup();
        arms.setName("arms");


        MuscleGroup shoulders = new MuscleGroup();
        shoulders.setName("shoulders");

        MuscleGroup back = new MuscleGroup();
        back.setName("back");

        MuscleGroup chest = new MuscleGroup();
        chest.setName("chest");

        List<MuscleGroup> muscleGroups = new ArrayList<>();
        muscleGroups.add(arms);
        muscleGroups.add(legs);
        muscleGroups.add(shoulders);
        muscleGroups.add(back);
        muscleGroups.add(chest);
        muscleGroupRepository.save(arms);
        muscleGroupRepository.save(legs);
        muscleGroupRepository.save(shoulders);
        muscleGroupRepository.save(back);
        muscleGroupRepository.save(chest);

        Exercise shadowBoxing = new Exercise();
        shadowBoxing.setName("Shadow Boxing");
        shadowBoxing.setPartsTargeted(new HashSet<>(muscleGroups));
        exerciseRepository.save(shadowBoxing);

//        Exercise deepSquats = new Exercise();
//        deepSquats.setName("Deep Squats");
//        deepSquats.setPartsTargeted(Arrays.asList(legs));
//
//        exerciseRepository.save(deepSquats);
//
        Theme theme = new Theme();
        theme.setName("Loose Weight");
        themeRepository.save(theme);

        WorkoutExercise workoutExercise = new WorkoutExercise();
        workoutExercise.setExercise(shadowBoxing);
        workoutExercise.setRepititions(10);
        workoutExercise.setSets(3);
        workoutExercise.setWorkout(workout);

        workoutExerciseRepository.save(workoutExercise);

        WorkoutPlan workoutPlan = new WorkoutPlan();
        workoutPlan.setMuscleGroups(muscleGroups);
        workoutPlan.setThemes(Arrays.asList(theme));
        workoutPlan.setWorkoutExercises(Arrays.asList(workoutExercise));
        workoutPlan.setActivities(Arrays.asList());
        workoutPlan.setName("Crazy 5");
        workoutPlan.setDescription("Get crazy with this five muscle combo workout");
        workoutPlan.setSuitableFor("both");

        workoutPlanRepository.save(workoutPlan);



    }
}


